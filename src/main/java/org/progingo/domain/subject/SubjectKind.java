package org.progingo.domain.subject;

import lombok.Getter;
import org.progingo.domain.resource.ResourceType;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum SubjectKind {
    SINGLE(1),
    MULTIPLE(2),
    CHOICE(3),
    ;
    @Getter
    private final Integer code;

    SubjectKind(Integer code) {
        this.code = code;
    }

    private static Map<Integer, SubjectKind> codeMap;

    public static SubjectKind getByCode(Integer code) {
        if(codeMap == null) {
            codeMap = Arrays.stream(SubjectKind.values())
                    .collect(Collectors.toMap(SubjectKind::getCode, x -> x));
        }
        return codeMap.get(code);
    }


}
