package ru.geekbrains.java3.homeworks.homework4;

public class ABC {
    private static final Object mon = new Object();
    private static char letter = 'A';

    public static void main(String[] args) {
        new Thread(ABC::printA).start();
        new Thread(ABC::printB).start();
        new Thread(ABC::printC).start();
    }

    private static void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'A') {
                        mon.wait();
                    }
                    System.out.print(letter);
                    letter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'B') {
                        mon.wait();
                    }
                    System.out.print(letter);
                    letter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'C') {
                        mon.wait();
                    }
                    System.out.print(letter);
                    letter = 'A';
                    System.out.println();
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
