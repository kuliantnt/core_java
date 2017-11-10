package Unit5.Test5_2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n,double s,int year,int month,int day){
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1, day);
        hireDay = calendar.getTime();
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public String getName() {
        return name;
    }
    public void  raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }

    public void print(){
        System.out.printf("name = %s, salary = %.2f\n", getName(),getSalary());
    }
}
