package akki.mycollection.map;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class HashMapImpl {

    static Map<Integer, List<Employee>> employeeDOJMap = new HashMap<>();

    public static void main(String args[]) {



        Map<String, Integer> map = new HashMap<>();

        map.put("a",1);
        map.put("b",2);


        map.compute("b", (s, i) -> map.containsKey(s)?++i:1);
        map.compute("c", (s, i) -> map.containsKey(s)?++i:1);

        System.out.println(map);
        List<Employee> list2014 = new ArrayList<>();
        list2014.add(
                new Employee("Deborah Sprightly", 29, 9000.00));
        employeeDOJMap.put(2018, list2014);
        List<Employee> list2015 = new ArrayList<>();

        list2015.add(new Employee("Tom Jones", 45, 7000.00));
        list2015.add(new Employee("Harry Major", 25, 10000.00));
        employeeDOJMap.put(2015, list2015);
        List<Employee> list2016 = new ArrayList<>();
        list2016.add(new Employee("Ethan Hardy", 65, 8000.00));
        list2016.add(new Employee("Nancy Smith", 22, 12000.00));
        employeeDOJMap.put(2016, list2016);


        System.out.println("Using Map.forEach to print the Employee in employeeDOJMap multi-value map\n");
        employeeDOJMap.forEach((year, empList) -> System.out.println(year + "-->" + empList));

        System.out.println("\nCAPITALIZED Employee Names using Map.replaceAll()");
        employeeDOJMap.replaceAll((year, empList) -> {
            empList.replaceAll(emp -> {
                emp.setName(emp.getName().toUpperCase());
                return emp;
            });
            return empList;
        });
        employeeDOJMap.forEach((year, empList) -> System.out.println(year + "-->" + empList));

        //computeIfAbsent Example

        employeeDOJMap.computeIfAbsent(2018, ArrayList::new)
                .add(new Employee("Akhilesh", 12, 12.00));

        employeeDOJMap.get(22222).stream().collect(Collectors.toList());

        System.out.println("After ComputeIfAbsent");
        employeeDOJMap.forEach((year, empList) -> System.out.println(year + "-->" + empList));

        //computeIfPresent
        Employee shuchita = new Employee("Shuchita", 34, 34.00);
        //  employeeDOJMap.computeIfPresent(2018, (integer, employees) -> employees).add(shuchita);
        System.out.println();
        employeeDOJMap.forEach((year, empList) -> System.out.println(year + "-->" + empList));
        System.out.println();
        employeeDOJMap.computeIfPresent(201, (integer, employees) -> {
            employees.remove(shuchita);
            return employees;
        });

        employeeDOJMap.forEach((year, empList) -> System.out.println(year + "-->" + empList));

        employeeDOJMap.compute(2016, (integer, employees) -> {
            if (!employees.contains(shuchita)) {
                employees.add(shuchita);
            }
            return employees;
        });
        System.out.println("After Compute");
        employeeDOJMap.forEach((year, empList) -> System.out.println(year + "-->" + empList));

        employeeDOJMap.keySet().forEach(key -> {
            employeeDOJMap.merge(key, list2014, (employees, employees2) -> {
                employees.addAll(employees2);
                return employees;
            });
        });
        System.out.println("After Merge");
        employeeDOJMap.forEach((year, empList) -> System.out.println(year + "-->" + empList));

    }
}

class Employee {
    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String toString() {
        DecimalFormat dformat = new DecimalFormat(".##");
        return "Employee Name:" + this.name
                + "  Age:" + this.age
                + "  Salary:" + dformat.format(this.salary);
    }
//getters and setters for name, age and salary go here
//standard equals() and hashcode() code go here
}

class Symbol{

}
