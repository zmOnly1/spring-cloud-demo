package com.example.guice;

import com.google.inject.Guice;

/**
 * Created by zm on 2018/8/18.
 */
public class App {

    public static void main(String[] args) {
        MyApplet applet = Guice.createInjector(new MainModule()).getInstance(MyApplet.class);
        applet.run();
    }


}
