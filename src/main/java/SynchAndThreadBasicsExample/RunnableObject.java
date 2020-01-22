package SynchAndThreadBasicsExample;

public class RunnableObject implements Runnable {
    private BankAccount bankAccount = new BankAccount();

    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdrawl(10);
            System.out.println("Account: " + bankAccount.getBalance());
            if (bankAccount.getBalance() < 0) {
                System.out.println("OVERDRAWN!!!!!!");
            }
        }
    }

    //very important to have synchronized modifier here
    //allows only ONE thread to run this method at a time, and must fully complete before "handing over the key" so new thread can run
    //important to maintain accuracy of bankAccount balance...dont have multiple threads updating it concurrently
    private synchronized void makeWithdrawl(Integer amount) {
        if (bankAccount.getBalance() >= amount) {
        System.out.println(Thread.currentThread().getName() + " bout to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " going to sleep.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(Thread.currentThread().getName() + " woke up.");
        bankAccount.withdrawMoney(amount);
        System.out.println(Thread.currentThread().getName() + " withdrew $10");
        } else {
            System.out.println("Not enough money");
        }
    }
}
