package com.company.util;

import java.util.Scanner;

public class ReaderImpl implements Reader{
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String readString() {
        return scanner.next();
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public double readDouble() {
        return scanner.nextDouble();
    }
}
