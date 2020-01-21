
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RunnableObject runnableObject = new RunnableObject();

        Thread zach = new Thread(runnableObject);
        Thread kelli = new Thread(runnableObject);

        zach.setName("Zach");
        kelli.setName("Kelli");

        zach.start();
        kelli.start();

    }
}
