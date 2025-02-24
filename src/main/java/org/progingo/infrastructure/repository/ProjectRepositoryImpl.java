package org.progingo.infrastructure.repository;

import org.progingo.dao.ProjectDao;
import org.progingo.domain.project.Project;
import org.progingo.domain.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    private ProjectDao projectDao;
    @Override
    public boolean save(Project project) {
        project.setGmtCreate(new Date());
        int r = projectDao.insert(project);
        return r == 1;

    }
}
