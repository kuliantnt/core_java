package Unit5.Test5_9;


import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee {


    private double salary;

    private String name;


    private Date hireDay;

    /**
     * @param n the employee name
     * @param s the employee salary
     * @param year the employee hire year
     * @param month the employee hire month
     * @param day the employee hire day
     */
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        //已经确定other obj是Employee以及并不为空
        Employee other = (Employee) obj;

        return Objects.equals(name, other.name) && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    String getHireDay() {
        DateFormat df = DateFormat.getDateInstance();
        return df.format(hireDay);
    }

    /**
     * @return Employee string
     */
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + "" +
                ",hireDay=" + getHireDay()
                + "]";
    }
}
