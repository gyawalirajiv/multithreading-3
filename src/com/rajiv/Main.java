package com.rajiv;

public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1 waiting for lock 2");
                synchronized (lock2){
                    System.out.println("Thread 1 has lock 1 and lock 2");
                }
                System.out.println("Thread 1 released lock 2");
            }
            System.out.println("Thread 1 released lock 1");
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2 has lock 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2 waiting for lock 1");
                synchronized (lock2){
                    System.out.println("Thread 2 has lock 1 and lock 2");
                }
                System.out.println("Thread 2 released lock 1");
            }
            System.out.println("Thread 2 released lock 2");
        }
    }

}
