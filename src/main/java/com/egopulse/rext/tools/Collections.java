package com.egopulse.rext.tools;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collections {
    public static <T> Set<T> setOf(T ... ts) {
        return Stream.of(ts).collect(Collectors.toSet());
    }

    public static <T> List<T> listOf(T ... ts) {
        return Stream.of(ts).collect(Collectors.toList());
    }
}
