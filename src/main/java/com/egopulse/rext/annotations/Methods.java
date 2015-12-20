package com.egopulse.rext.annotations;

import java.lang.annotation.*;
import java.util.stream.Stream;

public enum Methods {
    GET(com.egopulse.rext.annotations.GET.class);

    private final Class<? extends Annotation> type;

    public Methods of(Class<Annotation> type) {
        return Stream.of(Methods.values())
                .filter(method -> method.type == type)
                .findFirst()
                .orElse(GET);
    }

    Methods(Class<? extends Annotation> type) {
        this.type = type;
    }
}
