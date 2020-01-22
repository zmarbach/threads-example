package WaitAndNotifyExample;

public class Consumer implements  Runnable{
    Q q;

    //set Q and start the thread when Consumer is created
    public Consumer(Q q) {
        this.q = q;
        Thread consumerThread = new Thread(this, "Consumer");
        consumerThread.start();
    }


    //consumer thread just gets the num (set by Producer)
    @Override
    public void run() {
        while(true){
            q.getNum();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

