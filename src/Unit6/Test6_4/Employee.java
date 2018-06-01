package Unit6.Test6_4;


import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {

    private static int nextID = 1;
    private final String name;
    private int id;
    private double salary;


    private Date hireDay;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        hireDay = new Date();
    }

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calender = new GregorianCalendar(year, month - 1, day);
        hireDay = calender.getTime();
        id = nextID;
        ++nextID;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHirDay = new GregorianCalendar(year, month - 1, day).getTime();
        this.hireDay.setTime(newHirDay.getTime());
    }

    //现在已经不使用toLocaleString,使用DateFormat来初始化
    private String getHireDay() {
        DateFormat df = DateFormat.getDateInstance();
        return df.format(hireDay);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    int getId() {
        return id;
    }

    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",HireDay=" + getHireDay() + "]";
    }
}
