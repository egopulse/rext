package com.egopulse.rext;

import java.net.URI;

public class RestResult {

    private int status = 200;
    private Object entity = null;
    private URI location = null;

    public int getStatus() {
        return status;
    }

    public Object getEntity() {
        return entity;
    }

    public URI getLocation() {
        return location;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private RestResult result = new RestResult();

        public Builder status(int status) {
            result.status = status;
            return this;
        }

        public Builder redirect(URI uri) {
            result.location = uri;
            result.status = 304;
            return this;
        }

        public Builder badRequest() {
            result.status = 400;
            return this;
        }

        public Builder badRequest(Object entity) {
            result.status = 400;
            result.entity = entity;
            return this;
        }

        public Builder unauthorized() {
            result.status = 401;
            return this;
        }

        public Builder forbidden() {
            result.status = 403;
            return this;
        }

        public Builder ok() {
            result.status = 200;
            return this;
        }

        public Builder ok(Object entity) {
            result.status = 200;
            result.entity = entity;
            return this;
        }

        public RestResult build() {
            return result;
        }
    }

}
