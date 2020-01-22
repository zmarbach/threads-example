package SynchAndJoinExample;

public class Counter implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        increment();
    }

    //need this synchronized, otherwise wont get consistent results
    //without synch, BOTH threads may be reading the value of count at the same time, so they both see it as being 600 and both increment it to 601 (instead of 601, then 602)
    //synch forces ONE thread to complete all logic in method before next thread can come in (so ONE thread increments to 601, then the next comes in and increments to 602...etc)
    public synchronized void increment(){
        for(int i=0; i<1000; i++){
            count = count + 1;
        }
    }

    public int getCount() {
        return count;
    }
}
