package Unit4.Test4_2;

import java.util.Locale;

public class Test4_2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CHINA);
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 7500, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        for(Employee e : staff){
            e.raiseSalary(5);
        }
        for(Employee e : staff){
            System.out.printf("ID = %2d\tname = %s\tsalary = %.2f\thireDay = %s. \n",e.getId()
                    , e.getName() , e.getSalary(),e.getHireDay());
        }
    }
}
