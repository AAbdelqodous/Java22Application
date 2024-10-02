package com.abdelqodous.kw.lambda;

public class LambdaDemo {
    public static void main(String[] args) {
        Printable printable = (s) -> "printing: " +s;
        System.out.println(printable.print("English handbook"));
    }
}
