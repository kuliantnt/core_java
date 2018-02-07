package Unit6.Test6_3;

import Unit6.Test6_4.Employee;

public class CloneTest {
    public static void main(String[] args){
        try{
            Employee original = new Employee("john.Public",50000);
            original.setHireDay(2000,1,1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002,12,31);
            System.out.println("original="+original);
            System.out.println("copy="+copy);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
