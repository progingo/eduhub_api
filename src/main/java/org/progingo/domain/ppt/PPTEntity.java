package org.progingo.domain.ppt;


import lombok.Builder;
import lombok.Data;

@Data
public class PPTEntity {
    private String title;

    private String slides;

    private String viewportsize;

    private String viewportratio;

    public static PPTEntity getEmptyTemplate(){
        PPTEntity pptEntity = new PPTEntity();
        pptEntity.setTitle("新建空白幻灯片");
        pptEntity.setSlides("[\n" +
                "    {\n" +
                "      \"id\": \"test-slide-1\",\n" +
                "      \"elements\": [],\n" +
                "      \"background\": {\n" +
                "        \"type\": \"solid\",\n" +
                "        \"color\": \"#fff\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]");
        pptEntity.setViewportsize("1000");
        pptEntity.setViewportratio("562.5");
        return pptEntity;
    }
}
