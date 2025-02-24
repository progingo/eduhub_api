package org.progingo.infrastructure.repository;

import org.progingo.dao.ProjectDao;
import org.progingo.domain.project.Project;
import org.progingo.domain.project.ProjectBO;
import org.progingo.domain.project.ProjectExample;
import org.progingo.domain.project.ProjectRepository;
import org.progingo.infrastructure.project.ProjectAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectAdapter projectAdapter;

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
}
