package edu.eci.arsw.math;

public class PiDigitsThread extends Thread{
    private final int start;
    private final int count;
    private byte[] result;

    public PiDigitsThread (int start, int count){
        this.start = start;
        this.count = count;
    }

    @Override
    public void run () {
        result = PiDigits.getDigitsSequential(start, count);
    }

    public byte [] getresult() {
        return result;
    }
}
