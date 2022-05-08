package Lesson_4.Homework;

public class WaitNotifyClass {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private final int LENGTH = 10;

    public static void main(String[] args) {
        WaitNotifyClass waitNotifyObj = new WaitNotifyClass();
        Thread threadA = new Thread(() -> waitNotifyObj.printChar('A', 'B'));
        Thread threadB = new Thread(() -> waitNotifyObj.printChar('B', 'C'));
        Thread threadC = new Thread(() -> waitNotifyObj.printChar('C', 'A'));
        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void printChar(char sym, char nextSym) {
        synchronized (mon) {
            try {
                for (int i = 0; i < LENGTH; i++) {
                    while (currentLetter != sym) {
                        mon.wait();
                    }
                    System.out.print(sym);
                    currentLetter = nextSym;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
