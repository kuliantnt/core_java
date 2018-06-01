package Unit14.test14_12;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base direction(e.g. /usr/local/jdk1.6.0/src): ");
        String directory = in.nextLine();
        System.out.print("Enter keyword(e,g. volatile): ");
        String keyword = in.nextLine();
        File file = new File(directory.trim());
        if (!file.isDirectory()) {
            System.exit(1);
        } else if (!file.exists()) {
            System.exit(1);
        }

        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter counter = new MatchCounter(file, keyword, pool);
        Future<Integer> result = pool.submit(counter);
        try{
            System.out.println(result.get() + " matching files.");
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();

        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("largest pool size=" + largestPoolSize);
    }

}
class MatchCounter implements Callable<Integer> {

    private File directory;
    private String keyword;
    private int count;
    private ExecutorService pool;

    MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory =directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            if (files == null)
                return 0;
            for (File file : files) {
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, keyword,pool);
                    Future<Integer> result= pool.submit(counter);
                    results.add(result);
                } else {
                    if (search(file)) {
                        count++;
                    }
                }
            }
            for (Future<Integer> result : results) {
                try {
                    count += result.get();

                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
        }
        return count;
    }
    private boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file)) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) {
                        found = true;
                        System.out.println(file.getName());
                    }
                }
                return found;
            }
        } catch (IOException e) {
            return false;
        }
    }
}
