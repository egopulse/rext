package com.egopulse.rext.impl;

import com.egopulse.rext.*;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public class VertxRegistor implements RextRegistor {

    private final Router router;

    public static VertxRegistor provision(Router router) {
        VertxRegistor adapter = new VertxRegistor(router);
        adapter.provision();
        return adapter;
    }

    public VertxRegistor(Router router) {
        this.router = router;
    }

    @Override
    public void provision() {
        RestSuite suite = getRestSuite();
        suite.modules().stream().forEach(this::provisionModule);

        System.out.println(suite.modules());
    }

    private void provisionModule(RestModule module) {
        module.getMethods().stream().forEach(method -> this.provisionMethod(method, module));
    }

    private void provisionMethod(RestMethod method, RestModule module) {
        System.out.println(method.path());
        System.out.println(method.reference());

        router.route(HttpMethod.GET, method.path())
                .produces("application/json")
                .handler(routingContext -> {
                    routingContext.response().putHeader("content-type", "text/html");
                    Resolver resolver = new VertxResolver(routingContext);

                    RestResult result = method.execute(resolver);
                    resolver.resolveResult(result);
                });
    }
}
