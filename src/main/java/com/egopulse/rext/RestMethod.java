package com.egopulse.rext;

import com.egopulse.rext.annotations.Methods;

import java.util.List;
import java.util.Set;

public interface RestMethod {

    Class<?> reference();
    String path();
    Set<Methods> methods();
    List<Param> params();

    RestResult execute(Resolver resolver);
}
