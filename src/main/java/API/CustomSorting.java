package API;

import java.util.*;
import java.util.stream.Collectors;

class Student implements Comparable<Student> {
    String name;
    Integer age;

    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        int x = this.age - s.age;
        if(x==0){
            return this.name.compareTo(s.name);
        }
        return x;
    }
}

class StudentSort implements Comparator<Student>{

    public int compare(Student s1,Student s2){
        return s1.age - s2.age;
    }
}

public class CustomSorting {
    public static void start() {

        Student student = new Student("B",3);
        Student student1 = new Student("A",2);
        Student student2 = new Student("B",5);
        Student student4 = new Student("B",1);
        Student student3 = new Student("A",3);

        List<Student> list = new ArrayList<>(List.of(student1,student2,student3,student,student4));

//        Collections.sort(list);
//
//        list.forEach(e -> System.out.println(e.name + " " + e.age));

//        list.stream().collect(Collectors.toMap(e->e.name + e.age,e->e,(e,e1)->e)).values().stream().sorted((a, b)->{
//            int x = a.age - b.age;
//            if(x==0){
//                return a.name.compareTo(b.name);
//            }
//            return x;
//        }).forEach((e)-> System.out.println(e.name + " " + e.age));
//        Collections.sort(list,new StudentSort());
        List<Student> result = list.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(e -> e.name))
                        ),
                        ArrayList::new
                ));

        result.forEach(e -> System.out.println(e.name + " " + e.age));

    }
}