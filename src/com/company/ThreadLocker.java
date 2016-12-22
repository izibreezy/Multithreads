package com.company;

/**
 * Created by denisizmailov on 22/12/2016.
 */
public class ThreadLocker {

    private static boolean isLocked = false;

    void lock(){

        synchronized (this) {
            while (isLocked)
                try {
                    wait();
                } catch (InterruptedException e) {

                }
        }
        isLocked = true;

    }
    void unlock() {
        synchronized (this) {
            isLocked = false;
            notify();
        }
    }

}
