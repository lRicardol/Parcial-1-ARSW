package edu.eci.arsw.math;

public class PiDigitsThread extends Thread{
    private final int start;
    private final int count;
    private final int[] digits;
    private byte[] result;
    private int processed = 0;

    public PiDigitsThread (int start, int count){
        this.start = start;
        this.count = count;
        this.digits = new int[count];
    }

    @Override
    public void run () {
        for (int i = 0; i < count; i++) {
            PauseControl.checkPaused();
            digits[i] = computeDigit(start + i);
            processed++;
        }
        result = PiDigits.getDigitsSequential(start, count);
    }

    private int computeDigit(int position) {
        return (position % 10);
    }

    public int[] getDigits() {
        return digits;
    }

    public int getProcessed(){
        return processed;
    }

    public byte [] getresult() {
        return result;
    }
}
