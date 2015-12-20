package com.egopulse.rext.sample;

import com.egopulse.rext.impl.VertxRegistor;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class SimpleVertxApp extends AbstractVerticle {

    public static void main(String args[]) {
        Launcher.executeCommand("run", SimpleVertxApp.class.getName());
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        VertxRegistor.provision(router);

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080);
    }
}
