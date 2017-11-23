package Unit5.Test5_11;

import Unit5.Test5_9.Employee;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String [] args){
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Carl Cracker",75_000,1987,12,15));
        staff.add(new Employee("Harry Hacker",50_000,1989,10,1));
        staff.add(new Employee("Tony Tester",40_000,1990,3,15));

        for(Employee e : staff){
            e.raiseSalary(5);
        }
        for(Employee e :staff){
            System.out.println(e);
        }
    }
}
