package org.progingo.application;

import org.progingo.domain.subject.SubjectBO;
import org.progingo.domain.subject.SubjectRepository;
import org.progingo.domain.user.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SubjectApp {

    @Autowired
    private SubjectRepository subjectRepository;

    public ActionResult addSubject(SubjectBO subjectBO) {
        subjectBO.setKey(UUID.randomUUID().toString().replaceAll("-", ""));
        boolean r = subjectRepository.insertSubject(subjectBO);
        if (r) {
            return ActionResult.ok();
        } else {
            return ActionResult.fail("添加题目失败");
        }

    }
}
