package org.progingo.controller.request.project;

import lombok.Data;

import java.util.List;

@Data
public class AddMemberRequest {
    private String projectKey;
    List<String> usernameList;
}
