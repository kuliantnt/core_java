package Unit14.test14_8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] account;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance){
        account = new double[n];
        for(int i = 0; i< account.length;i++){
            account[i] = initialBalance;
        }
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }


    public void transfer(int from, int to , double amount,int no) throws InterruptedException{
        bankLock.lock();
        try{
            while(account[from] < amount)
                sufficientFunds.await();
            System.out.print(no + " ");
            System.out.print(Thread.currentThread());
            account[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount,from,to);
            account[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n",getTotalBalance());
            sufficientFunds.signalAll();
        }finally{
            bankLock.unlock();
        }
    }

    private double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : account) {
                sum += a;
            }
            return sum;
        }
        finally {
            bankLock.unlock();
        }
    }
    public int size(){
        return account.length;
    }

}
