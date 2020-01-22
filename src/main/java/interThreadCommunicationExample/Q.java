package interThreadCommunicationExample;

public class Q {
    private int num;

    public void getNum() {
        System.out.println("Get: " + num);
    }

    public void setNum(int num) {
        this.num = num;
        System.out.println("Set: " + num);
    }
}
