import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Client Joe = new Client(5000);
        Client Tom = new Client(20005);

        Thread thread1 = new Thread(() -> {
            System.out.println("Joe sending money to Tom...");
            try {
                Joe.transferMoney(Tom, 5);
            }
            catch (InterruptedException exception) {
                System.out.println(exception.toString());
            }
            System.out.println("Tom receive money, Tom balance:" + Tom.toString());
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println("Tom sending money to Joe...");    try {
                Tom.transferMoney(Joe, 1000);
            }
            catch (InterruptedException exception) {
                System.out.println(exception.toString());
            }
            System.out.println("Joe receive money, Joe balance:" + Joe.toString());
        }, "Thread2");

        thread1.start();
        thread2.start();
    }
}
