package akki.mycollection;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public class Employee implements Comparable<Employee> {
    private String name;
    private Integer age;

    private static String dummyName = "Akhilesh";
    private static int dummyAge = 20;
    private static int dummySuffix = 1;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Employee) obj).getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String toString() {
        DecimalFormat dformat = new DecimalFormat(".##");
        return "Employee Name:" + this.name
                + "  Age:" + this.age
                ;
    }

    @Override
    public int compareTo(Employee o) {
        return   o.getAge()-this.age;
    }

    public static Employee newEmployee(int suffix) {

        return  new Employee(dummyName + suffix, dummyAge + suffix);
    }
//getters and setters for name, age and salary go here
//standard equals() and hashcode() code go here
}