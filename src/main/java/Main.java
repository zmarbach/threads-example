import SynchAndThreadBasicsExample.RunnableObject;
import SynchAndJoinExample.Counter;
import WaitAndNotifyExample.Consumer;
import WaitAndNotifyExample.Producer;
import WaitAndNotifyExample.Q;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //toggle these values based on which example you want to run
        boolean useCounterExample = false;
        boolean useBankAccountExample = false;
        boolean useInterThreadCommunicationExample = true;

        if(useBankAccountExample){
            System.out.println("---------- START ----------");
            RunnableObject runnableObject = new RunnableObject();

            Thread zach = new Thread(runnableObject);
            Thread kelli = new Thread(runnableObject);

            zach.setName("Zach");
            kelli.setName("Kelli");

            zach.start();
            kelli.start();

            //these joins force the main method to wait until zach and kelli threads are finished before continuing and printing "END"
            zach.join();
            kelli.join();
            System.out.println("---------- END ----------");
        }

        if(useCounterExample){
            System.out.println("---------- START ----------");
            Counter counter = new Counter();

            Thread t1 = new Thread(counter);
            Thread t2 = new Thread(counter);

            t1.start();
            t2.start();

            //these joins force the main method to wait until zach and kelli threads are finished before continuing and printing "END"
            t1.join();
            t2.join();
            System.out.println("Count: " + counter.getCount());
            System.out.println("---------- END ----------");

        }

        if(useInterThreadCommunicationExample){
            System.out.println("---------- START ----------");
            Q q = new Q();
            new Producer(q);
            new Consumer(q);
        }
    }
}
