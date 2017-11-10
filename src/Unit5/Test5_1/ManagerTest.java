package Unit5.Test5_1;

import Unit5.Test5_2.Employee;
import Unit5.Test5_3.Manager;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Carl Cracker", 80_000, 1987, 12, 15);
        boss.setBonus(5_000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker",50_000,1989,10,1);
        staff[2] = new Employee("Tommy Tester",40_000,1990,3,15);

        for(Employee e: staff){
            e.print();
        }
    }
}
