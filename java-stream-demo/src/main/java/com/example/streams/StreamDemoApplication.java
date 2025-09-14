package com.example.streams;

import com.example.streams.demo.BasicStreamOperations;
import com.example.streams.demo.OptionalDemo;
import com.example.streams.model.Person;
import java.time.LocalDate;
import java.util.List;

public class StreamDemoApplication {
    public static void main(String[] args) {
        List<Person> people = createSampleData();
        
        System.out.println("=== Basic Stream Operations ===");
        BasicStreamOperations operations = new BasicStreamOperations(people);
        operations.getFullName().forEach(System.out::println);
        
        System.out.println("\n=== Optional Demo ===");
        OptionalDemo optionalDemo = new OptionalDemo(people);
        optionalDemo.demonstrateOptionalUsage();
        
    }

    private static List<Person> createSampleData() {
        return List.of(
            new Person("Sai", "Bhargav", 25, LocalDate.of(1998, 5, 15), 60000, "New York"),
            new Person("Ram", "Nithin", 30, LocalDate.of(1993, 8, 22), 75000, "Chicago"),
            new Person("Appa", "Rapali", 22, LocalDate.of(2001, 3, 10), 48000, "New York"),
            new Person("Akhil", "Uppu", 35, LocalDate.of(1988, 11, 5), 90000, "Chicago"),
            new Person("GL", "Wilson", 28, LocalDate.of(1995, 7, 30), 55000, "Boston")
        );
    }
}
