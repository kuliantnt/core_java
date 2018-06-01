package Unit5.Test5_10;

import Unit5.Test5_9.Employee;
import java.util.Objects;

public class Manager extends Employee {

    private double bonus;

    /**
     * @param n the manage name
     * @param s the manage salary
     * @param year the manage hire year
     * @param month the manage hire month
     * @param day the manage hire day
     */
    public Manager(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Manager other = (Manager) obj;
        return bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }


    @Override
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
