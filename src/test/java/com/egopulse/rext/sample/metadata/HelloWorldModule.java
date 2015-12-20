package com.egopulse.rext.sample.metadata;

import com.egopulse.rext.*;
import com.egopulse.rext.annotations.Methods;
import com.egopulse.rext.sample.HelloWorldResource;
import com.egopulse.rext.tools.Collections;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloWorldModule implements RestModule {

    private Set<RestMethod> METHODS = Collections.setOf(new HelloWorldMethod());

    @Override
    public Set<RestMethod> getMethods() {
        return METHODS;
    }

    private class HelloWorldMethod implements RestMethod {
        private Class<HelloWorldResource> reference = HelloWorldResource.class;
        private String path = "/hello/world";
        private Set<Methods> methods = Stream.of(Methods.GET).collect(Collectors.toSet());

        @Override
        public Class<?> reference() {
            return reference;
        }

        @Override
        public String path() {
            return path;
        }

        @Override
        public Set<Methods> methods() {
            return methods;
        }

        @Override
        public List<Param> params() {
            return null;
        }

        @Override
        public RestResult execute(Resolver resolver) {
            HelloWorldResource resource = resolver.resolveRestResource(reference);
            String path = resolver.resolveQueryParam("path");
            String param2 = resolver.resolvePathParam("param2");

            Object result = resource.helloWorld(path, param2);
            return RestResult.builder().ok(result).build();
        }
    }

}
