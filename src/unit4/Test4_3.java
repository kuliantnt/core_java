package unit4;


import java.util.Locale;

public class Test4_3 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        Employee4_3[] staff = new Employee4_3[3];
        staff[0] = new Employee4_3("Tom", 40_000);
        staff[1] = new Employee4_3("Dick", 60_000);
        staff[2] = new Employee4_3("Harry", 65_000);

        for (Employee4_3 e : staff) {
            e.setId();
            System.out.printf("name = %6s,\tid = %2d,\tsalary = %.2f\n"
                    , e.getName(), e.getId(), e.getSalary());
        }
        int n = Employee4_3.getNextID();
        System.out.println("Next available id= " + n);
    }
}
class Employee4_3 {
    private static int nextID = 1;

    private int id;
    private final String name;
    private double salary;

    Employee4_3(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }


    int getId() {
        return id;
    }

    void setId() {
        id = nextID;
        nextID++;
    }

    static int getNextID() {
        return nextID;
    }

    public static void main(String[] args) {
        Employee4_4 e = new Employee4_4("harry", 50_000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
