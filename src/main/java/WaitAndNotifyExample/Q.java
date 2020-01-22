package WaitAndNotifyExample;

public class Q {
    private int num;
    private boolean valueSet = false;

    public synchronized void getNum(){
        //if value has not been set yet, then WAIT until Producer sets it
        while (!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get: " + num);
        valueSet = false;
        //have to notify the other thread that THIS thread is done, so can STOP waiting and move on with execution
        notify();
    }

    public synchronized void setNum(int num) {
        //if value has already been set, then WAIT until Consumer gets it
        while (valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.num = num;
        valueSet = true;
        System.out.println("Set: " + num);
        //have to notify the other thread that THIS thread is done, so can STOP waiting and move on with execution
        notifyAll();
    }
}
