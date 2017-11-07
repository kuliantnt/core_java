package Unit4.Test4_4;

class Employee {
    private final String name;
    private double salary;

    Employee(String n, double s) {
        name = n;
        salary = s;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
