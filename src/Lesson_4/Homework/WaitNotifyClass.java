package Lesson_4.Homework;

public class WaitNotifyClass {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private final int LENGTH = 10;

    public static void main(String[] args) {
        WaitNotifyClass waitNotifyObj = new WaitNotifyClass();
        Thread threadA = new Thread(waitNotifyObj::printA);
        Thread threadB = new Thread(waitNotifyObj::printB);
        Thread threadC = new Thread(waitNotifyObj::printC);
        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < LENGTH; i++) {
                    while (currentLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < LENGTH; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < LENGTH; i++) {
                    while (currentLetter != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
