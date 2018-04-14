package Unit14.test14_9;


import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bank {
    private static final Logger logger = LogManager.getLogger("Bank");
    private final double[] account;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public Bank(int n, double initialBalance) {
        account = new double[n];
        for (int i = 0; i < account.length; i++) {
            account[i] = initialBalance;
        }
    }

    public synchronized void transfer(int from, int to, double amount)
            throws InterruptedException {
        while (account[from] < amount)
            wait();
        int i = atomicInteger.incrementAndGet();
        logger.printf(Level.INFO,"count: %d ",i);
        logger.printf(Level.INFO,Thread.currentThread().toString());
        account[from] -= amount;
        logger.printf(Level.INFO," %10.2f from %d to %d", amount, from, to);
        account[to] += amount;
        logger.printf(Level.INFO," Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    private synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : account) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return account.length;
    }
}
