package Unit4.Test4_5;

import java.util.Random;

class Employee {
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
    Employee(String aName, double aSalary){
        name = aName;
        salary = aSalary;
    }

    Employee(double s){
        this("Employee #_nexId",s );
    }

    Employee(){

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
