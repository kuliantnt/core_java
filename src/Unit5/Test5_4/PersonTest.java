package Unit5.Test5_4;

import Unit5.Test5_5.Person;
import Unit5.Test5_6.Employee;
import Unit5.Test5_7.Student;

public class PersonTest {
    public static void main(String [] args){
        Person[] people = new Person[2];

        people[0] = new Employee("Harry Hacker",50_000,1989,10,1);
        people[1] = new Student("Maria Morris","computer science");

        for(Person p : people)
            System.out.println(p.getName() + "," + p.getDescription());
    }
}
