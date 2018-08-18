package com.example.guice;

/**
 * Created by zm on 2018/8/18.
 */
public class Configuration {

    public static MyApplet getMainApplet() {
        return new StringWritingApplet(new PrintStringWriter(System.out), new StringProvider() {
            @Override
            public String get() {
                return "Hello World!";
            }
        });
    }

}
