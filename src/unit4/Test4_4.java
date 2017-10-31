package unit4;

public class Test4_4 {
    public static void main(String[] args) {
       /*
         Test 1: method can't modify numeric parameters
        */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /*
          Test 2:Method can change the state of object parameters
         */
        System.out.println("\nTesting tripleSalary");
        Employee4_4 harry = new Employee4_4("Harry", 50_000);
        System.out.println("Before: salary= " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary= " + harry.getSalary());

        /*
          Test 3: Methods can't attach new objects to object parameters
         */
        System.out.println("\nTesting swap:");
        Employee4_4 a = new Employee4_4("Alice", 70_000);
        Employee4_4 b = new Employee4_4("Bob", 60_000);
        System.out.println("Before: a= " + a.getName());
        System.out.println("Before: b= " + b.getName());
        swap(a, b);
        System.out.println("After: a= " + a.getName());
        System.out.println("After: b= " + b.getName());
    }

    private static void tripleValue(double x) { // doesn't work
        x = 3 * x;
        System.out.println("End of method: x= " + x);
    }

    private static void tripleSalary(Employee4_4 x) {//work
        x.raiseSalary(200);
        System.out.println("End of method: salary= " + x.getSalary());
    }

    private static void swap(Employee4_4 x, Employee4_4 y) {
        Employee4_4 temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());

    }
}

class Employee4_4 {
    private final String name;
    private double salary;

    Employee4_4(String n, double s) {
        name = n;
        salary = s;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
