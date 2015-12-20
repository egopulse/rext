package com.egopulse.rext;

public class RextFrameworkManager {

    private final RextRegistor adapter;
    private static RextFrameworkManager INSTANCE;

    private RextFrameworkManager(RextRegistor adapter) {
        this.adapter = adapter;
    }

    public static RextFrameworkManager initialize(RextRegistor adapter) {
        if (INSTANCE != null) {
            INSTANCE = new RextFrameworkManager(adapter);
        }
        return INSTANCE;
    }

    public static RextFrameworkManager getInstance() {
        return INSTANCE;
    }

    public RextRegistor currentAdapter() {
        return adapter;
    }

}
