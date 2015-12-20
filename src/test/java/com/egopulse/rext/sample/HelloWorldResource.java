package com.egopulse.rext.sample;

import com.egopulse.rext.annotations.*;
import io.vertx.core.json.JsonObject;

@Restful
@Path("/hello")
public class HelloWorldResource {

    @Path("/world/:param2")
    @GET
    public JsonObject helloWorld(@QueryParam String path, @PathParam String param2) {
        return new JsonObject();
    }
}
