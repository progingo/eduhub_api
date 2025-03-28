package org.progingo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.controller.request.subject.AddSubjectRequest;
import org.progingo.domain.user.UserBO;
import org.progingo.service.SubjectService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/add")
    @RequiresAuthentication
    public JsonResult addSubject(@RequestBody AddSubjectRequest addSubjectRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        JsonResult jsonResult = subjectService.addSubject(user, addSubjectRequest);
        return jsonResult;
    }

}
