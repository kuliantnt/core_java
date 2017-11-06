package unit4;

import java.util.Locale;
import java.util.Random;

public class Test4_5 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        Employee4_5[] staff = new Employee4_5[3];
        staff[0] = new Employee4_5("Tom", 40_000);
        staff[1] = new Employee4_5(60_000);
        staff[2] = new Employee4_5();

        for (Employee4_5 e : staff) {
            System.out.printf("name = %6s,\tid = %2d,\tsalary = %.2f\n"
                    , e.getName(), e.getId(), e.getSalary());
        }
    }
}

class Employee4_5 {
    private static int nextId;
    private int id;
    private String name = "";
    private double salary;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(10_000);
    }

    {
        id = nextId;
        nextId++;
    }
    Employee4_5(String aName, double aSalary){
        name = aName;
        salary = aSalary;
    }

    Employee4_5(double s){
        this("Employee #_nexId",s );
    }

    Employee4_5(){

    }

    public static int getNextId() {
        return nextId;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }
}