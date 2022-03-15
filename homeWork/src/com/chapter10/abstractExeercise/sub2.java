package com.chapter10.abstractExeercise;

public class  sub2 extends Template {
    @Override
    public void job() {
        long sum = 0;
        for (long i = 0; i < 100000000; i++) {
            sum +=i;
        }
    }
}
