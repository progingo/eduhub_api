package org.progingo.domain.project;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum ProjectMemberRole {

    ONLY_READ_MEMBER(0),
    MEMBER(1),
    ADMIN(2),
    MASTER(3),  // 创建者

    ;
    private final Integer code;

    ProjectMemberRole(Integer code) {
        this.code = code;
    }

    private static Map<Integer,ProjectMemberRole> codeMap;

    public static ProjectMemberRole getByCode(Integer code) {
        if(codeMap == null) {
            codeMap = Arrays.stream(ProjectMemberRole.values())
                    .collect(Collectors.toMap(ProjectMemberRole::getCode, x -> x));
        }
        return codeMap.get(code);
    }
}
