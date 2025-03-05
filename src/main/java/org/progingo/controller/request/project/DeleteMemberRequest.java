package org.progingo.controller.request.project;

import lombok.Data;

import java.util.List;

@Data
public class DeleteMemberRequest {
    private String projectKey;
    List<String> usernameList;
    boolean isDelete ;

}
