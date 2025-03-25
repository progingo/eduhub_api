package org.progingo.infrastructure.subject;

import org.progingo.dao.SubjectDao;
import org.progingo.domain.subject.Subject;
import org.progingo.domain.subject.SubjectBO;
import org.progingo.domain.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public boolean insertSubject(SubjectBO subjectBO) {
        Subject subject = adapter(subjectBO);
        subject.setGmtCreate(new Date());
        int r = subjectDao.insertSelective(subject);
        return r == 1;
    }



    private Subject adapter(SubjectBO subjectBO){
        Subject subject = new Subject();
        subject.setId(subjectBO.getId());
        subject.setKey(subjectBO.getKey());
        subject.setResourceKey(subjectBO.getResourceKey());
        subject.setTitle(subjectBO.getTitle());
        subject.setXx1(subjectBO.getXx1());
        subject.setXx2(subjectBO.getXx2());
        subject.setXx3(subjectBO.getXx3());
        subject.setXx4(subjectBO.getXx4());
        subject.setXx5(subjectBO.getXx5());
        subject.setAnalysis(subjectBO.getAnalysis());
        subject.setAnswer(subjectBO.getAnswer());
        subject.setKind(subjectBO.getKind().getCode());
        subject.setIsDelete(subjectBO.getIsDelete());
        subject.setGmtCreate(subjectBO.getGmtCreate());
        return subject;
    }
}
