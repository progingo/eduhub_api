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

import java.util.ArrayList;

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

    @GetMapping("/tree/{resourceKey}")
    @RequiresAuthentication
    public JsonResult getPPTTree(@PathVariable String resourceKey){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return pptService.getPPTTree(user,resourceKey);
    @GetMapping("/{id1}/{id2}")
    public JsonResult getPPTS(@PathVariable("id1") Integer id1,@PathVariable("id2") Integer id2) {
        System.out.println(id1);
        System.out.println(id2);
        String ppt1 = pptService.getPPT(id1);
        String ppt2 = pptService.getPPT(id2);
        ArrayList<String> datas = new ArrayList<>();
        datas.add(ppt1);
        datas.add(ppt2);
        return JsonResult.ok(datas);
    }

    @GetMapping("{id}")
    public JsonResult getPPT(@PathVariable("id") Integer id){
        System.out.println(id);
        return JsonResult.ok(pptService.getPPT(id));

    }

    @GetMapping("/init")
    public String getInitPPT(){

        return "[\n" +
                "    {\n" +
                "      \"id\": \"test-slide-1\",\n" +
                "      \"elements\": [],\n" +
                "      \"background\": {\n" +
                "        \"type\": \"solid\",\n" +
                "        \"color\": \"#fff\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]";
    }
}
