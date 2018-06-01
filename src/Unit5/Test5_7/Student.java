package Unit5.Test5_7;

import Unit5.Test5_5.Person;

public class Student extends Person {

    private String major;

    /**
     * @param n name
     * @param m major
     */
    public Student(String n, String m) {
        super(n);
        major = m;
    }

    /**
     * @return a student majoring "major"
     */
    @Override
    public String getDescription() {
        return "a student majoring" + getMajor();
    }

    public String getMajor() {
        return major;
    }
}
