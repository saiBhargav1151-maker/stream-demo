package com.example.streams.model;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person>{
	private final String firstName;
	private final String lastName;
	private final int age;
	private final LocalDate birthDate;
	private final double salary;
	private final String city;
	public Person(String firstName, String lastName, int age, LocalDate birthDate, double salary, String city) {
		
		this.firstName =Objects.requireNonNull(firstName);
		this.lastName = Objects.requireNonNull(lastName);
		this.age = age;
		this.birthDate = birthDate;
		this.salary = salary;
		this.city = city;
	}
	// Getters
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public double getSalary() {
		return salary;
	}
	public String getCity() {
		return city;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, birthDate, city, firstName, lastName, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(birthDate, other.birthDate) && Objects.equals(city, other.city)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", birthDate=" + birthDate
				+ ", salary=" + salary + ", city=" + city + "]";
	}
	
	@Override
	public int compareTo(Person o) {
		
		return this.lastName.compareTo(o.lastName);
	}
	
	
	
	
	
}
