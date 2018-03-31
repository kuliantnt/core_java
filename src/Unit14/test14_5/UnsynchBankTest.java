package Unit14.test14_5;

import Unit14.test14_6.Bank;
import Unit14.test14_7.TransferRunnable;

public class UnsynchBankTest {
    private static final int NACCOUNTS = 100;
    private static final double INITAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS,INITAL_BALANCE);
        int i ;
        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i , INITAL_BALANCE);
            Thread t = new Thread(r);
            t.start();

        }
    }

}
