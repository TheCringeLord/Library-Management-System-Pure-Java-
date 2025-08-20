package com.pm.library.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class SystemConsoleIO implements ConsoleIO {
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @Override
    public String readLine(String prompt) {
        try {
            System.out.print(prompt);
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }
}
