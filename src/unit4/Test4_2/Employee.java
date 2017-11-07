package unit4.Test4_2;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

class Employee {
   private static int nextID = 1;
   private int id;
   private final String name;
   private double salary;
   private Date hireDay;

   Employee(String n, double s, int year, int month, int day) {
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
