package Unit4.Test4_4;


public class ParamTest {

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
        Employee harry = new Employee("Harry", 50_000);
        System.out.println("Before: salary= " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary= " + harry.getSalary());

        /*
          Test 3: Methods can't attach new objects to object parameters
         */
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70_000);
        Employee b = new Employee("Bob", 60_000);
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

    private static void tripleSalary(Employee x) {//work
        x.raiseSalary(200);
        System.out.println("End of method: salary= " + x.getSalary());
    }

    private static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());

    }
}

