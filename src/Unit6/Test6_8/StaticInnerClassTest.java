package Unit6.Test6_8;

public class StaticInnerClassTest {

    public static void main(String[] args) {
        double[] d = new double[10];
        for (int i = 1; i != d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minMax(d);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        System.out.println("min = " + p.getFirst());
        System.out.println("Max = " + p.getSecond());
    }
}

class ArrayAlg {

    public static Pair minMax(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }
        return new Pair(min, max);
    }

    public static class Pair {

        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }
}
