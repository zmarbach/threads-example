package WaitAndNotifyExample;

public class Producer implements  Runnable{
    Q q;

    //set Q and start the thread when Producer is created
    public Producer(Q q) {
        this.q = q;
        Thread producerThread = new Thread(this, "Producer");
        producerThread.start();
    }


    //Producer thread increments num every time it runs (which should be read by Consumer thread)
    @Override
    public void run() {
        int i = 0;
        while(true){
            q.setNum(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
