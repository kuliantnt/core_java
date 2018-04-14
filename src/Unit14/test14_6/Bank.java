package Unit14.test14_6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();


    /**
     * 银行程序
     * @param n 账户数量
     * @param initialBalance 期初余额
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
    }

    /**
     * 转账
     * @param from 来自账户
     * @param to 目标账户
     * @param amount 数量
     * @param no 编号
     */
    public void transfer(int from, int to, double amount,int no) {
        bankLock.lock();

        try {
            if (accounts[from] < amount)
                return;
            System.out.print(no);
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }finally{
            bankLock.unlock();
        }
    }

    /**
     * 获取全部的账户余额
     * @return 全部余额
     */
    private double getTotalBalance() {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
    }

    /**
     * 账户数量
     * @return 数量
     */
    public int size() {
        return accounts.length;
    }
}
