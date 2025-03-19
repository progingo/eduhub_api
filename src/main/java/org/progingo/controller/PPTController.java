package org.progingo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.controller.request.ppt.CommitPPTRequest;
import org.progingo.controller.request.ppt.CreatePPTRequest;
import org.progingo.controller.request.ppt.MergePPTRequest;
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

    @GetMapping("/tree/{resourceKey}")
    @RequiresAuthentication
    public JsonResult getPPTTree(@PathVariable String resourceKey) {
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return pptService.getPPTTree(user, resourceKey);
    }


    /**
     *
     * @param key1 第一个节点的ppt_tree的key
     * @param key2 第二个节点的ppt_tree的key
     * @return
     */
    @GetMapping("/merge/{key1}/{key2}")
    @RequiresAuthentication
    public JsonResult getMergePPT(@PathVariable("key1") String key1,@PathVariable("key2") String key2) {
        System.out.println(key1);
        System.out.println(key2);
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();

        return pptService.getMergePPT(user, key1, key2);

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

    /**
     *
     * @param mergePPTRequest 这里面的两个key是节点的key
     * @return
     */
    @PostMapping("/merge")
    @RequiresAuthentication
    public JsonResult mergePPT(@RequestBody MergePPTRequest mergePPTRequest){
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return pptService.mergePPT(user, mergePPTRequest);

    }
}
