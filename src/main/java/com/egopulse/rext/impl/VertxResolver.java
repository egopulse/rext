package com.egopulse.rext.impl;

import com.egopulse.rext.Resolver;
import com.egopulse.rext.RestResult;
import com.egopulse.rext.annotations.Methods;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class VertxResolver implements Resolver {

    private final RoutingContext context;

    public VertxResolver(RoutingContext context) {
        this.context = context;
    }

    @Override
    public <T> T resolveQueryParam(String paramName) {
        return null;
    }

    @Override
    public <T> T resolvePathParam(String paramName) {
        return null;
    }

    @Override
    public <T> T resolveContextParam(String paramName, Class<?> paramType) {
        return null;
    }

    @Override
    public <T> T resolveRestResource(Class<T> resource) {
        try {
            return resource.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void resolveResult(RestResult result) {
        context.response().setStatusCode(result.getStatus());
        Object entity = result.getEntity();
        if (entity != null) {
            if (entity instanceof JsonObject) {
                context.response().end(((JsonObject) entity).encode());
            }
        } else {
            context.response().end();
        }
    }

    @Override
    public <T> T resolveType(Class<T> type) {
        return null;
    }

    @Override
    public <T> T resolveHttpMethod(Methods method) {
        return null;
    }
}
