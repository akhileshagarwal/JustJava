package akki.mycollection.map;

import akki.mycollection.Employee;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class TreeMapImpl {

    static Map<Employee, String> employeeToNameMap = new TreeMap<>();

    public static void main(String[] args) {
        IntStream.range(1,5).boxed()
                .map(Employee::newEmployee)
                .forEach(employee -> employeeToNameMap.put(employee, employee.getName()));

       employeeToNameMap.forEach((employee, s) -> {
           System.out.println(employee);

           System.out.println();
       });
    }
}
