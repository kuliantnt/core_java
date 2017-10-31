package unit4;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Test4_2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        Employee4_2[] staff = new Employee4_2[3];
        staff[0] = new Employee4_2("Carl Cracker", 7500, 1987, 12, 15);
        staff[1] = new Employee4_2("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee4_2("Tony Tester", 40000, 1990, 3, 15);
        for(Employee4_2 e : staff){
            e.raiseSalary(5);
        }
        for(Employee4_2 e : staff){
            System.out.printf("ID = %2d\tname = %s\tsalary = %.2f\thireDay = %s. \n",e.getId()
                    , e.getName() , e.getSalary(),e.getHireDay());
        }
    }
}
 class Employee4_2 {
    private static int nextID = 1;
    private int id;
    private final String name;
    private double salary;
    private Date hireDay;

    Employee4_2(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calender = new GregorianCalendar(year, month - 1, day);
        hireDay = calender.getTime();
        id = nextID;
        ++nextID;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    //现在已经不使用toLocaleString,使用DateFormat来初始化
    String getHireDay() {
        DateFormat df = DateFormat.getDateInstance();
        return df.format(hireDay);
    }

    void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    int getId() {
        return id;
    }
}
