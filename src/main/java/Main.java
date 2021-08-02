public class Main {
        public static String Lock1 = "passcode";
        public static String Lock2 = "passcode2";

        public static void main(String args[]) {
            Thread1 T1 = new Thread1();
            Thread2 T2 = new Thread2();
            T1.start();
            T2.start();
        }

        private static class Thread1 extends Thread {
            public void run() {
                synchronized (Lock1) {
                    System.out.println("Thread 1: Holding lock 1...");

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {}
                    System.out.println("Thread 1: Waiting for lock 2...");

                    synchronized (Lock2) {
                        System.out.println("Thread 1: Holding lock 1 & 2...");
                    }
                }
            }
        }
        private static class Thread2 extends Thread {
            public void run() {
                synchronized (Lock1) {
                    System.out.println("Thread 2: Holding lock 1...");

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {}
                    System.out.println("Thread 2: Waiting for lock 2...");

                    synchronized (Lock2) {
                        System.out.println("Thread 2: Holding lock 1 & 2...");
                    }
                }
            }
        }
    }
