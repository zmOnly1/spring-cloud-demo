package com.example.guice;

import com.google.inject.AbstractModule;

import java.io.*;

/**
 * Created by zm on 2018/8/19.
 */
public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        //bind(String.class).toInstance("Hello World!");
        //bind(String.class).toProvider(() -> "Hello World!");
        bind(String.class).annotatedWith(Output.class).toInstance("Hello World!");
    }

    //@Provides
    //private String getString(){
    //    return "Hello World!";
    //}
}
