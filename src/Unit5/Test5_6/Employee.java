package Unit5.Test5_6;

import Unit5.Test5_5.Person;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person {

    private double salary;


    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    private Date hireDay;

    /**
     * @param n the employee name
     * @param s the employee salary
     * @param year the employee hire year
     * @param month the employee hire month
     * @param day the employee hire day
     */
    public Employee(String n, double s, int year, int month, int day) {
        super(n);
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
