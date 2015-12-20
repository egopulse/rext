package com.egopulse.rext;

import com.egopulse.rext.annotations.Methods;

import java.util.Iterator;
import java.util.ServiceLoader;

public interface RextRegistor {

    void provision();

    default RestSuite getRestSuite() {
        Iterator<RestSuite> suites = ServiceLoader.load(RestSuite.class).iterator();
        if (suites.hasNext()) {
            return suites.next();
        } else {
            throw new IllegalStateException("No available RestSuite to provision");
        }
    }
}