package API;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Data
class Employee {

    String name;
    String department;
    Long salary;

    Employee(String name, String department,Long salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class StreamsExample {
    public static void start(){
        List<Integer> list = List.of(1,2,3,4,5);
        List<Integer> list1 = List.of(1,2,3,4,5);
        List<Integer> result = Stream.of(list, list1).flatMap(e->e.stream()).collect(Collectors.toList());
        System.out.println(result.stream().reduce(0,(a,b)->a+b));

        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Map<String, List<Integer>> groupResult = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println(groupResult);

        List<Employee> employees = List.of(
                new Employee("Abhishek", "IT",1l),
                new Employee("Rahul", "HR",2l),
                new Employee("Amit", "IT",3l)
        );

        Map<String, List<Employee>> grouped = employees.stream().collect(Collectors.groupingBy(e -> e.department));
        grouped.forEach((dept, group) -> {
            System.out.println(dept + " -> " + group.size());
        });

        Map<String,Long> stringListMap = employees.stream().collect(
                Collectors.groupingBy((Employee e)->e.getDepartment(),Collectors.counting()));
        System.out.println(stringListMap);
    }
}