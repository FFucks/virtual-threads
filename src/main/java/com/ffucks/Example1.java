package com.ffucks;

public class Example1 {

    public static void main(String[] args) throws Exception {
        Thread.startVirtualThread(() -> {
            System.out.println("Running virtual thread: " +
                    Thread.currentThread());
        });

        Thread.sleep(200);
    }
}
