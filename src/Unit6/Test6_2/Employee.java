package Unit6.Test6_2;

public class Employee implements Comparable<Employee> {
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;

    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;

    }

    /**
     * Compares employee by salary
     * @param o another Employee object
     * @return a negative value if this employee has a lower salary then
     * otherObject, 0 if the salaries are the same, a positive value otherwise
     */
    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}
