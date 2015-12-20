package com.egopulse.rext.sample.metadata;

import com.egopulse.rext.RestModule;
import com.egopulse.rext.RestSuite;
import com.egopulse.rext.tools.Collections;

import java.util.Set;

public class SimpleRestSuite implements RestSuite {

    protected Set<RestModule> MODULES = Collections.setOf(
            new HelloWorldModule()
    );

    @Override
    public Set<RestModule> modules() {
        return MODULES;
    }
}
