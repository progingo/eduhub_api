package org.progingo.domain.resource;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ResourceType {
    PPT(1)
    ;
    @Getter
    private final Integer code;

    ResourceType(Integer code) {
        this.code = code;
    }

    private static Map<Integer, ResourceType> codeMap;

    public static ResourceType getByCode(Integer code) {
        if(codeMap == null) {
            codeMap = Arrays.stream(ResourceType.values())
                    .collect(Collectors.toMap(ResourceType::getCode, x -> x));
        }
        return codeMap.get(code);
    }
}
