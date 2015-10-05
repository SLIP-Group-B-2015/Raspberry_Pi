package com.company;

public class Main {

    private static final Boolean DEBUG = true;

    public static void main(String[] args) {
        if (DEBUG) {
            Debugger debugWindow = new Debugger();
            debugWindow.spawn();
        }
    }
}
