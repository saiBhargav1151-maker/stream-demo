package com.example.streams.demo;

import com.example.streams.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class OptionalDemo {
    private final List<Person> people;

    public OptionalDemo(List<Person> people) {
        this.people = people;
    }

    public void demonstrateOptionalUsage() {
        // Creating Optional
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> ofOptional = Optional.of("Hello");
        
        // Optional.ofNullable - safe for possible null values
        String possibleNull = Math.random() > 0.5 ? "Value" : null;
        Optional<String> nullableOptional = Optional.ofNullable(possibleNull);

        // Retrieving values
        System.out.println("orElse: " + emptyOptional.orElse("Default"));
        System.out.println("orElseGet: " + emptyOptional.orElseGet(() -> "Generated"));
        
        // Conditional actions
        ofOptional.ifPresent(val -> System.out.println("Value present: " + val));
        
        // Chaining operations
        nullableOptional.map(String::toUpperCase)
                       .ifPresent(System.out::println);

        // Filtering
        ofOptional.filter(s -> s.length() > 3)
                  .ifPresent(System.out::println);

        // FlatMap for nested Optionals
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("Nested"));
        Optional<String> flattened = nestedOptional.flatMap(Function.identity());

        // Finding person example
        findPersonByCity("New York")
                .map(Person::getFirstName)
                .ifPresentOrElse(
                    name -> System.out.println("Found: " + name),
                    () -> System.out.println("Not found")
                );

        // orElseThrow
        try {
            String result = emptyOptional.orElseThrow(
                () -> new IllegalArgumentException("Value missing"));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }

    private Optional<Person> findPersonByCity(String city) {
        return people.stream()
                .filter(p -> city.equals(p.getCity()))
                .findFirst();
    }

    // Demonstrating anti-patterns
    public void demonstrateAntiPatterns() {
        // Don't do this - using isPresent() and get()
        Optional<String> optional = Optional.of("Value");
        if (optional.isPresent()) {  // Anti-pattern
            String value = optional.get(); // Better to use functional approaches
            System.out.println(value);
        }

        // Better approach
        optional.ifPresent(System.out::println);
    }
}