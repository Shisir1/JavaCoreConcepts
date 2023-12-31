package org.example.mapVsFlatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> cities = new ArrayList<>();
        cities.add("Banepa");
        cities.add("Kathmandu");
        cities.add("Bhaktapur");
        cities.add("Lalitpur");

        Employee emp1 = new Employee(1,"Shisir",cities);

        List<String> cities2 = new ArrayList<>();
        cities2.add("Banepa");
        cities2.add("Kathmandu");
        cities2.add("Bhaktapur");

        Employee emp2 = new Employee(2,"Ramila",cities2);

        List<String> cities3 = new ArrayList<>();
        cities3.add("Banepa");
        cities3.add("Kathmandu");

        Employee emp3 = new Employee(3,"Basanta",cities3);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        System.out.println(employees);

//        List<Integer> ids = new ArrayList<>();
//        for(Employee employee : employees){
//            ids.add(employee.getId());
//        }
//        System.out.println(ids);

        //Using Method reference
//        List<Integer> ids = employees.stream().map(Employee::getId).toList();
//        System.out.println(ids);

        //Using Lambda Expression
        List<Integer> id2 = employees.stream().map(emp -> emp.getId()).collect(Collectors.toList());
        System.out.println(id2);

        //Using FlatMap -> to flatten the list and remove the duplicate elements
        Set<String> citiesWorkedInFlattened =  employees.stream().flatMap(employee -> employee.getCitiesWorkedIn().stream()).collect(Collectors.toSet());
        System.out.println(citiesWorkedInFlattened);


    }
}
