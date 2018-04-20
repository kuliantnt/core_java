package Unit14.test14_13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    public static void main(String[] args) {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0 ; i < SIZE; i++)
            numbers[i]= Math.random();
        Counter counter= new Counter(numbers, 0, numbers.length, t -> t > 0.5);
        ForkJoinPool  pool = new ForkJoinPool();
        pool.invoke(counter);
        int poolSize = pool.getPoolSize();
        System.out.println(poolSize);
        System.out.println(counter.join());
    }
}

interface Filter{
    boolean accept(double t);
}

class Counter extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private Filter filter;

    Counter(double[] values, int from, int to, Filter filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    @Override
    protected Integer compute() {
        if(to -from < THRESHOLD)
        {
            int count = 0;
            for (int i = from; i< to; i++) {
                if (filter.accept(values[i]))
                    count++;
            }
            return count;
        }
        else{
            int mid = (from + to )/ 2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, from, mid, filter);
            invokeAll(first,second);
            return first.join() + second.join();
        }
    }
}