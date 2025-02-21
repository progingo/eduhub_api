package org.progingo.controller;

import org.progingo.controller.request.SavePPTRequest;
import org.progingo.service.PPTService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ppt")
public class PPTController {

    @Autowired
    private PPTService pptService;

    @PostMapping("/save")
    public void savePPT(@RequestBody SavePPTRequest savePPTRequest){
        //System.out.println(savePPTRequest);
        pptService.savePPT(savePPTRequest);
    }

    @GetMapping("{id}")
    public JsonResult getPPT(@PathVariable("id") Integer id){
        System.out.println(id);
        return JsonResult.ok(pptService.getPPT(id));

        /*return "[\n" +
                "  {\n" +
                "    \"id\": \"test-slide-1\",\n" +
                "    \"elements\": [\n" +
                "      {\n" +
                "        \"type\": \"shape\",\n" +
                "        \"id\": \"4cbRxp\",\n" +
                "        \"left\": 0,\n" +
                "        \"top\": 200,\n" +
                "        \"width\": 546,\n" +
                "        \"height\": 362.5,\n" +
                "        \"viewBox\": [200, 200],\n" +
                "        \"path\": \"M 0 0 L 0 200 L 200 200 Z\",\n" +
                "        \"fill\": \"#5b9bd5\",\n" +
                "        \"fixedRatio\": false,\n" +
                "        \"opacity\": 0.7,\n" +
                "        \"rotate\": 0\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"shape\",\n" +
                "        \"id\": \"ookHrf\",\n" +
                "        \"left\": 0,\n" +
                "        \"top\": 0,\n" +
                "        \"width\": 300,\n" +
                "        \"height\": 320,\n" +
                "        \"viewBox\": [200, 200],\n" +
                "        \"path\": \"M 0 0 L 0 200 L 200 200 Z\",\n" +
                "        \"fill\": \"#5b9bd5\",\n" +
                "        \"fixedRatio\": false,\n" +
                "        \"flipV\": true,\n" +
                "        \"rotate\": 0\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"text\",\n" +
                "        \"id\": \"idn7Mx\",\n" +
                "        \"left\": 355,\n" +
                "        \"top\": 65.25,\n" +
                "        \"width\": 450,\n" +
                "        \"height\": 188,\n" +
                "        \"lineHeight\": 1.2,\n" +
                "        \"content\": \"<p><strong><span style=\\\"font-size: 112px;\\\">PPTist</span></strong></p>\",\n" +
                "        \"rotate\": 0,\n" +
                "        \"defaultFontName\": \"\",\n" +
                "        \"defaultColor\": \"#333\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"text\",\n" +
                "        \"id\": \"7stmVP\",\n" +
                "        \"left\": 355,\n" +
                "        \"top\": 253.25,\n" +
                "        \"width\": 585,\n" +
                "        \"height\": 56,\n" +
                "        \"content\": \"<p><span style=\\\"font-size: 24px;\\\">该消息来自后端</span></p>\",\n" +
                "        \"rotate\": 0,\n" +
                "        \"defaultFontName\": \"\",\n" +
                "        \"defaultColor\": \"#333\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"line\",\n" +
                "        \"id\": \"FnpZs4\",\n" +
                "        \"left\": 361,\n" +
                "        \"top\": 238,\n" +
                "        \"start\": [0, 0],\n" +
                "        \"end\": [549, 0],\n" +
                "        \"points\": [\"\", \"\"],\n" +
                "        \"color\": \"#5b9bd5\",\n" +
                "        \"style\": \"solid\",\n" +
                "        \"width\": 2\n" +
                "      }\n" +
                "    ],\n" +
                "    \"background\": {\n" +
                "      \"type\": \"solid\",\n" +
                "      \"color\": \"#ffffff\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"test-slide-2\",\n" +
                "    \"elements\": [\n" +
                "      {\n" +
                "        \"type\": \"text\",\n" +
                "        \"id\": \"ptNnUJ\",\n" +
                "        \"left\": 145,\n" +
                "        \"top\": 148,\n" +
                "        \"width\": 711,\n" +
                "        \"height\": 77,\n" +
                "        \"lineHeight\": 1.2,\n" +
                "        \"content\": \"<p style=\\\"text-align: center;\\\"><strong><span style=\\\"font-size: 48px;\\\">在此处添加标题</span></strong></p>\",\n" +
                "        \"rotate\": 0,\n" +
                "        \"defaultFontName\": \"\",\n" +
                "        \"defaultColor\": \"#333\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"text\",\n" +
                "        \"id\": \"mRHvQN\",\n" +
                "        \"left\": 207.50000000000003,\n" +
                "        \"top\": 249.84259259259264,\n" +
                "        \"width\": 585,\n" +
                "        \"height\": 56,\n" +
                "        \"content\": \"<p style=\\\"text-align: center;\\\"><span style=\\\"font-size: 24px;\\\">在此处添加副标题</span></p>\",\n" +
                "        \"rotate\": 0,\n" +
                "        \"defaultFontName\": \"\",\n" +
                "        \"defaultColor\": \"#333\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"line\",\n" +
                "        \"id\": \"7CQDwc\",\n" +
                "        \"left\": 323.09259259259267,\n" +
                "        \"top\": 238.33333333333334,\n" +
                "        \"start\": [0, 0],\n" +
                "        \"end\": [354.8148148148148, 0],\n" +
                "        \"points\": [\"\", \"\"],\n" +
                "        \"color\": \"#5b9bd5\",\n" +
                "        \"style\": \"solid\",\n" +
                "        \"width\": 4\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"shape\",\n" +
                "        \"id\": \"09wqWw\",\n" +
                "        \"left\": -27.648148148148138,\n" +
                "        \"top\": 432.73148148148147,\n" +
                "        \"width\": 1056.2962962962963,\n" +
                "        \"height\": 162.96296296296296,\n" +
                "        \"viewBox\": [200, 200],\n" +
                "        \"path\": \"M 0 20 C 40 -40 60 60 100 20 C 140 -40 160 60 200 20 L 200 180 C 140 240 160 140 100 180 C 40 240 60 140 0 180 L 0 20 Z\",\n" +
                "        \"fill\": \"#5b9bd5\",\n" +
                "        \"fixedRatio\": false,\n" +
                "        \"rotate\": 0\n" +
                "      }\n" +
                "    ],\n" +
                "    \"background\": {\n" +
                "      \"type\": \"solid\",\n" +
                "      \"color\": \"#fff\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"test-slide-3\",\n" +
                "    \"elements\": [\n" +
                "      {\n" +
                "        \"type\": \"shape\",\n" +
                "        \"id\": \"vSheCJ\",\n" +
                "        \"left\": 183.5185185185185,\n" +
                "        \"top\": 175.5092592592593,\n" +
                "        \"width\": 605.1851851851851,\n" +
                "        \"height\": 185.18518518518516,\n" +
                "        \"viewBox\": [200, 200],\n" +
                "        \"path\": \"M 0 0 L 200 0 L 200 200 L 0 200 Z\",\n" +
                "        \"fill\": \"#5b9bd5\",\n" +
                "        \"fixedRatio\": false,\n" +
                "        \"rotate\": 0\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"shape\",\n" +
                "        \"id\": \"Mpwv7x\",\n" +
                "        \"left\": 211.29629629629628,\n" +
                "        \"top\": 201.80555555555557,\n" +
                "        \"width\": 605.1851851851851,\n" +
                "        \"height\": 185.18518518518516,\n" +
                "        \"viewBox\": [200, 200],\n" +
                "        \"path\": \"M 0 0 L 200 0 L 200 200 L 0 200 Z\",\n" +
                "        \"fill\": \"#5b9bd5\",\n" +
                "        \"fixedRatio\": false,\n" +
                "        \"rotate\": 0,\n" +
                "        \"opacity\": 0.7\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"text\",\n" +
                "        \"id\": \"WQOTAp\",\n" +
                "        \"left\": 304.9074074074074,\n" +
                "        \"top\": 198.10185185185182,\n" +
                "        \"width\": 417.9629629629629,\n" +
                "        \"height\": 140,\n" +
                "        \"content\": \"<p style=\\\"text-align: center;\\\"><strong><span style=\\\"font-size: 80px;\\\"><span style=\\\"color: rgb(255, 255, 255);\\\">感谢观看</span></span></strong></p>\",\n" +
                "        \"rotate\": 0,\n" +
                "        \"defaultFontName\": \"\",\n" +
                "        \"defaultColor\": \"#333\",\n" +
                "        \"wordSpace\": 5\n" +
                "      }\n" +
                "    ],\n" +
                "    \"background\": {\n" +
                "      \"type\": \"solid\",\n" +
                "      \"color\": \"#fff\"\n" +
                "    }\n" +
                "  }\n" +
                "]";*/
    }
}
