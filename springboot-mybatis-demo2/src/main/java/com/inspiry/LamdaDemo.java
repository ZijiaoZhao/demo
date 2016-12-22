package com.inspiry;

/**
 * Created by zijiao on 12/15/16.
 */
public class LamdaDemo {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run 1.......");
            }
        };

        Runnable r1 = () -> System.out.println("run 2......");

        runnable.run();
        r1.run();
    }
}
