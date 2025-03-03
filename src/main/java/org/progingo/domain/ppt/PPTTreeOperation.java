package org.progingo.domain.ppt;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum PPTTreeOperation {
    CREAET(0),
    COMMIT(1),
    MERGE(2),

    ;

    @Getter
    private int code;

    private PPTTreeOperation(int code) {
        this.code = code;
    }


    private static Map<Integer, PPTTreeOperation> codeMap;

    public static PPTTreeOperation getByCode(Integer code) {
        if(codeMap == null) {
            codeMap = Arrays.stream(PPTTreeOperation.values())
                    .collect(Collectors.toMap(PPTTreeOperation::getCode, x -> x));
        }
        return codeMap.get(code);
    }
}
