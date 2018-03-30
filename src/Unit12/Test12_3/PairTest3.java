package Unit12.Test12_3;

public class PairTest3 {

    public static void main(String[] args) {
        Manager ceo = new Manager("Gus greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid sneaky", 600000, 2003, 12, 15);
        MyPair<Manager> buddies = new MyPair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        ceo.setBonus(500000);
        Manager[] managers = {ceo, cfo};
        MyPair<Employee> result = new MyPair<>();
        minMaxBouns(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", second: "
                + result.getSecond().getName());
        maxMinBouns(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", second: "
                + result.getSecond().getName());
    }


    public static void printBuddies(MyPair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }


    public static void minMaxBouns(Manager[] a, MyPair<? super Manager> result) {
        if (a == null || a.length == 0) {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) {
                min = a[i];
            }
            if (max.getBonus() < a[i].getBonus()) {
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxMinBouns(Manager[] a, MyPair<? super Manager> result) {
        minMaxBouns(a, result);
        PairAlg.swap(result);
    }

}


class PairAlg {

    public static boolean hasNulls(MyPair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(MyPair<?> p) {
        swapHelper(p);
    }

    private static <T> void swapHelper(MyPair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
