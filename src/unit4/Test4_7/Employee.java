package unit4.Test4_7;

import java.text.DateFormat;
import java.util.*;

public class Employee {
    private final String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calender = new GregorianCalendar(year, month - 1, day);
        hireDay = calender.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    //现在已经不使用toLocaleString,使用DateFormat来初始化
    public String getHireDay() {
        DateFormat df = DateFormat.getDateInstance();
        return df.format(hireDay);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
