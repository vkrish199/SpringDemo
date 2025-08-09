package com.varun;

public class Desktop implements Computer{

    public Desktop() {
        System.out.println("Desktop obj created");
    }

    @Override
    public void compile() {
        System.out.println("Compiling using Desktop");
    }
}
