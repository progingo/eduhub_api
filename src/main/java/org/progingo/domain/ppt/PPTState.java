package org.progingo.domain.ppt;

import lombok.Getter;
import org.progingo.domain.resource.ResourceType;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum PPTState {
    CREAET(0),
    NORMAL(1),
    DELETE(2),

    ;

    @Getter
    private int code;

    private PPTState(int code) {
        this.code = code;
    }


    private static Map<Integer, PPTState> codeMap;

    public static PPTState getByCode(Integer code) {
        if(codeMap == null) {
            codeMap = Arrays.stream(PPTState.values())
                    .collect(Collectors.toMap(PPTState::getCode, x -> x));
        }
        return codeMap.get(code);
    }


}
