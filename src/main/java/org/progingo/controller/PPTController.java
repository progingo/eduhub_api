package org.progingo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.controller.request.ppt.CommitPPTRequest;
import org.progingo.controller.request.ppt.CreatePPTRequest;
import org.progingo.controller.request.ppt.SavePPTRequest;
import org.progingo.domain.user.UserBO;
import org.progingo.service.PPTService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ppt")
public class PPTController {

    @Autowired
    private PPTService pptService;

    @PostMapping("/create")
    @RequiresAuthentication
    public JsonResult createPPT(@RequestBody CreatePPTRequest createPPTRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return pptService.createPPT(user, createPPTRequest);
    }

    @PostMapping("/save")
    @RequiresAuthentication
    public JsonResult savePPT(@RequestBody SavePPTRequest savePPTRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return pptService.savePPT(user,savePPTRequest);
    }

    @GetMapping("/{key}")
    @RequiresAuthentication
    public JsonResult getPPT(@PathVariable("key") String key){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return pptService.getPPT(user,key);
    }

    @PostMapping("/commit")
    @RequiresAuthentication
    public JsonResult commitPPT(@RequestBody CommitPPTRequest commitPPTRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return pptService.commitPPT(user,commitPPTRequest);
    }
}
