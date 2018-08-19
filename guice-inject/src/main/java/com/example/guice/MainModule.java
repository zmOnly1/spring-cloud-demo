package com.example.guice;

import com.google.inject.AbstractModule;

/**
 * Created by zm on 2018/8/19.
 */
public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new HelloWorldModule());
    }
}
