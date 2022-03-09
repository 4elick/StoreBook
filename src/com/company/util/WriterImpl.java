package com.company.util;

public class WriterImpl implements Writer {

    @Override
    public void write(String input) {
        System.out.println(input);
    }

    @Override
    public void writeInt(int input) {
        System.out.println(input);
    }

    @Override
    public void writeDouble(double input) {
        System.out.println(input);
    }


}
