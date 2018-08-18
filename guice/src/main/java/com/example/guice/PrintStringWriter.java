package com.example.guice;

import java.io.*;

/**
 * Created by zm on 2018/8/18.
 */
public class PrintStringWriter implements MyDestination {

    private PrintStream destination;

    public PrintStringWriter(PrintStream destination) {
        this.destination = destination;
    }

    @Override
    public void write(String str) {
        destination.println(str);
    }
}
