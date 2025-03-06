package org.progingo.infrastructure.repository;

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

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andUsernameEqualTo(username)
                .andRoleEqualTo(ProjectMemberRole.MASTER.getCode());
        projectMemberExample.setOrderByClause("gmt_create desc");

        List<ProjectMember> projectMembers = projectMemberDao.selectByExample(projectMemberExample);
        List<ProjectBO> projectBOList = projectMembers.stream().map(x ->{
            ProjectExample projectExample = new ProjectExample();
            projectExample.createCriteria().andKeyEqualTo(x.getProjectKey());
            Project project = projectDao.selectByExample(projectExample).stream().findFirst().orElse(null);
            return projectAdapter.toBO(project);
        }).collect(Collectors.toList());

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

        //项目成员
        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andIsDeleteEqualTo(false);

        List<UserBO> members = projectMemberDao.selectByExample(projectMemberExample)
                .stream()
                .map(x -> userRepository.findUserByUsername(x.getUsername()))
                .collect(Collectors.toList());

        return members;
    }

    @Override
    public boolean isAdmin(String projectKey, String username) {

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andRoleBetween(ProjectMemberRole.ADMIN.getCode(), ProjectMemberRole.MASTER.getCode())
                .andIsDeleteEqualTo(false);
        long projectMemberNumber = projectMemberDao.countByExample(projectMemberExample);

        return projectMemberNumber > 0;
    }

    /**
     * 查询是否为项目组成员，包括管理员和创建者
     * @param projectKey
     * @param username
     * @return
     */
    @Override
    public boolean isEditor(String projectKey, String username) {
        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andRoleBetween(ProjectMemberRole.MEMBER.getCode(), ProjectMemberRole.MASTER.getCode())
                .andIsDeleteEqualTo(false);
        long projectMemberNumber = projectMemberDao.countByExample(projectMemberExample);
        return projectMemberNumber > 0;
    }


    @Override
    public boolean isMember(String projectKey, String username) {
        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);

        long projectMemberNumber = projectMemberDao.countByExample(projectMemberExample);
        return projectMemberNumber > 0;
    }


    @Override
    public int findProjectMemberRole(String projectKey, String username) {

        ProjectMemberExample projectMemberExample = new ProjectMemberExample();
        projectMemberExample.createCriteria()
                .andProjectKeyEqualTo(projectKey)
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo(false);

        ProjectMember projectMember = projectMemberDao.selectByExample(projectMemberExample).stream().findFirst().orElse(null);

        return projectMember.getRole();
    }

    @Override
    public int deleteMember(String projectKey, Set<String> deleteMemberSet) {
        AtomicInteger num = new AtomicInteger();
        deleteMemberSet.forEach(x ->{
           if (userRepository.haveUser(x)){
               //伪删除，其实为修改is_delete字段为true
               ProjectMember projectMember = ProjectMember.builder()
                       .projectKey(projectKey)
                       .username(x)
                       .isDelete(true)
                       .gmtUpdate(new Date())
                       .build();
               ProjectMemberExample projectMemberExample = new ProjectMemberExample();
               projectMemberExample.createCriteria()
                       .andProjectKeyEqualTo(projectKey)
                       .andUsernameEqualTo(x);
               num.addAndGet(projectMemberDao.updateByExampleSelective(projectMember, projectMemberExample));
//               num.addAndGet(projectMemberDao.deleteByExample(projectMemberExample));
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

}
