package com.egopulse.rext;

import com.egopulse.rext.annotations.Methods;

public interface Resolver {
    <T> T resolveQueryParam(String paramName);
    <T> T resolvePathParam(String paramName);
    <T> T resolveContextParam(String paramName, Class<?> paramType);
    <T> T resolveRestResource(Class<T> resource);
    void resolveResult(RestResult result);
    <T> T resolveType(Class<T> type);
    <T> T resolveHttpMethod(Methods method);
}
