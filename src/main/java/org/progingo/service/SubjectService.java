package org.progingo.service;

import org.progingo.application.SubjectApp;
import org.progingo.controller.request.subject.AddSubjectRequest;
import org.progingo.domain.resource.ResourceRepository;
import org.progingo.domain.subject.SubjectBO;
import org.progingo.domain.subject.SubjectKind;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.ResultCode;
import org.progingo.domain.user.UserBO;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private SubjectApp subjectApp;

    public JsonResult addSubject(UserBO user, AddSubjectRequest addSubjectRequest) {
        boolean editor = resourceRepository.isEditor(addSubjectRequest.getResourceKey(), user.getUsername());
        if (!editor) {
            return JsonResult.fail(ResultCode.PERMISSION_DENIED.getMsg());
        }

        SubjectBO subjectBO = SubjectBO.builder()
                .resourceKey(addSubjectRequest.getResourceKey())
                .title(addSubjectRequest.getTitle())
                .xx1(addSubjectRequest.getXx1())
                .xx2(addSubjectRequest.getXx2())
                .xx3(addSubjectRequest.getXx3())
                .xx4(addSubjectRequest.getXx4())
                .xx5(addSubjectRequest.getXx5())
                .analysis(addSubjectRequest.getAnalysis())
                .kind(SubjectKind.getByCode(addSubjectRequest.getKind()))
                .answer(addSubjectRequest.getAnswer())
                .isDelete(false)
                .build();

        ActionResult actionResult = subjectApp.addSubject(subjectBO);
        if (!actionResult.isSuccess()) {
            return JsonResult.fail(actionResult.getMsg());
        }

        return JsonResult.ok();

    }
}
