package org.progingo.infrastructure.repository;

import org.progingo.controller.vo.ProjectMemberInfoVO;
import org.progingo.dao.ProjectDao;
import org.progingo.dao.ProjectMemberDao;
import org.progingo.domain.project.*;
import org.progingo.domain.user.UserBO;
import org.progingo.domain.user.UserRepository;
import org.progingo.infrastructure.project.ProjectAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectAdapter projectAdapter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectMemberDao projectMemberDao;

    @Override
    public boolean save(Project project) {
        project.setGmtCreate(new Date());
        int r = projectDao.insert(project);
        return r == 1;
    }

    @Override
    public List<ProjectBO> findProjectByPossessorUsername(String username) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria()
                .andPossessorUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);
        projectExample.setOrderByClause("gmt_create desc");
        List<ProjectBO> projectBOList = projectDao.selectByExample(projectExample)
                .stream()
                .map(x -> projectAdapter.toBO(x))
                .collect(Collectors.toList());

        return projectBOList;
    }

    @Override
    public List<UserBO> findProjectMember(String projectKey) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria()
                .andKeyEqualTo(projectKey);
        Project project = projectDao.selectByExample(projectExample).stream().findFirst().orElse(null);
        if (project == null){
            return Collections.emptyList();
        }
        LinkedList<UserBO> memberList = new LinkedList<>();
        //项目创建人
        memberList.add(userRepository.findUserByUsername(project.getPossessorUsername()));
        //项目成员
        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andIsDeleteEqualTo(false);

        List<UserBO> members = projectMemberDao.selectByExample(projectMemberExample)
                .stream()
                .map(x -> userRepository.findUserByUsername(x.getUsername()))
                .collect(Collectors.toList());
        memberList.addAll(members);

        return memberList;
    }

    @Override
    public boolean isAdmin(String projectKey, String username) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria()
                .andPossessorUsernameEqualTo(username)
                .andKeyEqualTo(projectKey);
        long projectNumber = projectDao.countByExample(projectExample);

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andRoleEqualTo(ProjectMemberRole.ADMIN.getCode())
                .andIsDeleteEqualTo(false);
        long projectMemberNumber = projectMemberDao.countByExample(projectMemberExample);

        return projectNumber + projectMemberNumber > 0;
    }

    /**
     * 查询是否为项目组成员，包括管理员和创建者
     * @param projectKey
     * @param username
     * @return
     */
    @Override
    public boolean isEditor(String projectKey, String username) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria()
                .andPossessorUsernameEqualTo(username)
                .andKeyEqualTo(projectKey);
        long projectNumber = projectDao.countByExample(projectExample);

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andRoleEqualTo(ProjectMemberRole.ADMIN.getCode())
                .andIsDeleteEqualTo(false);

        projectMemberExample.or()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andRoleEqualTo(ProjectMemberRole.MEMBER.getCode())
                .andIsDeleteEqualTo(false);

        long projectMemberNumber = projectMemberDao.countByExample(projectMemberExample);

        return projectNumber + projectMemberNumber > 0;
    }


    @Override
    public boolean isMember(String projectKey, String username) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria()
                .andPossessorUsernameEqualTo(username)
                .andKeyEqualTo(projectKey);
        long projectNumber = projectDao.countByExample(projectExample);

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);

        long projectMemberNumber = projectMemberDao.countByExample(projectMemberExample);
        return projectNumber + projectMemberNumber > 0;
    }

    @Override
    public int addMember(String projectKey, Set<String> addMemberSet) {
        AtomicInteger num = new AtomicInteger();
        addMemberSet.forEach(x ->{
            if (userRepository.haveUser(x)){
                ProjectMember projectMember = ProjectMember.builder()
                        .projectKey(projectKey)
                        .username(x)
                        .role(ProjectMemberRole.ONLY_READ_MEMBER.getCode())
                        .isDelete(false)
                        .gmtCreate(new Date())
                        .gmtUpdate(new Date())
                        .build();
                num.addAndGet(projectMemberDao.insert(projectMember));
            }

        });
        return num.get();
    }

    @Override
    public int findProjectMemberRole(String projectKey, String username) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria()
                .andPossessorUsernameEqualTo(username)
                .andKeyEqualTo(projectKey);
        long projectNumber = projectDao.countByExample(projectExample);
        if (projectNumber > 0){
            return ProjectMemberRole.MASTER.getCode();
        }
        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);
        return Objects.requireNonNull(projectMemberDao.selectByExample(projectMemberExample).stream().findFirst().orElse(null)).getRole();
    }

    @Override
    public int deleteMember(String projectKey, Set<String> deleteMemberSet) {
        AtomicInteger num = new AtomicInteger();
        deleteMemberSet.forEach(x ->{
           if (userRepository.haveUser(x)){
               ProjectMemberExample projectMemberExample = new ProjectMemberExample();
               projectMemberExample.createCriteria()
                       .andProjectKeyEqualTo(projectKey)
                       .andUsernameEqualTo(x)
                       .andIsDeleteEqualTo(false);
               num.addAndGet(projectMemberDao.deleteByExample(projectMemberExample));
           }
        });
        return num.get();
    }
    @Override
    public List<ProjectBO> findProjectByMemberUsername(String username) {
        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);
        Set<String> projectSet = projectMemberDao.selectByExample(projectMemberExample).stream()
                .map(ProjectMember::getProjectKey)
                .collect(Collectors.toSet());

        List<ProjectBO> projectBOList = projectSet.stream().map(x -> {
            ProjectExample projectExample = new ProjectExample();
            projectExample.createCriteria()
                    .andKeyEqualTo(x)
                    .andIsDeleteEqualTo(false);
            Project project = projectDao.selectByExample(projectExample).stream().findFirst().orElse(null);
            return projectAdapter.toBO(project);
        }).collect(Collectors.toList());

        return projectBOList;
    }

    @Override
    public boolean reviseRole(String projectKey, String username, Integer role) {
        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);
        return projectMemberDao.updateByExampleSelective(ProjectMember.builder().role(role).gmtUpdate(new Date()).build(), projectMemberExample) > 0;
    }


}
