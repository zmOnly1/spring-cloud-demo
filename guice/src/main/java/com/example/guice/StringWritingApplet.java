package com.example.guice;

public class StringWritingApplet implements MyApplet {

    private MyDestination destination;
    private StringProvider stringProvider;

    public StringWritingApplet(MyDestination destination, StringProvider stringProvider) {
        this.destination = destination;
        this.stringProvider = stringProvider;
    }

    private void writeString() {
        destination.write(stringProvider.get());
    }

    public void run() {
        writeString();
    }
}