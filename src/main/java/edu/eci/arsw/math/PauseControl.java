package edu.eci.arsw.math;

public class PauseControl {
    private static final Object lock = new Object();
    private static volatile boolean paused = false;

    private static void pauseALL(){
        paused = true;
    }

    public static void resumeALL() {
        synchronized (lock) {
            paused = false;
            lock.notifyAll();
        }
    }

    public static void checkPaused(){
        synchronized (lock) {
            while (paused) {
                try {
                    lock.wait();
                } catch (interruptedException e) {
                    thread.currentThead(). interrupt();
                }
            }
        }
    }
}

