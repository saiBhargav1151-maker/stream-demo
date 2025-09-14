package com.example.streams.demo;
import com.example.streams.model.Person;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Chromaticity;

import com.example.streams.model.*;


public class BasicStreamOperations {
	private final List<Person> people;

	public BasicStreamOperations(List<Person> people) {
		this.people=Collections.unmodifiableList(people);
	}
	
	public List<String> getFullName() {
		return people.stream().map(n->n.getFirstName()+" "+n.getLastName()).collect(Collectors.toList());
		
	}
	
	public List<String> getUpperCaseNames(){
		return people.stream().map(Person::getFirstName).map(String::toUpperCase).collect(Collectors.toList());
	}
	
	public List<Person> getAdults(){
		return people.stream().filter(n->n.getAge()>=18).collect(Collectors.toList());
	}
	public List<Person> getHighEarnersInCity(String city){
		return people.stream().filter(n->n.getSalary()>50000).filter(n->city.equals(n.getCity())).collect(Collectors.toList());
		
	}
	
	public double getTotalSalary(){
		return people.stream().map(Person::getSalary).reduce(0.0,Double::sum);
	}
	
	public List<Person> getPeopleSortedByAge(){
		return people.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());
	}
	public Map<String, Double> getAverageSalaryByCity(){
		return people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.averagingDouble(Person::getSalary)));
	}
	
	
	public List<PersonDto> toDTO(){
		return people.stream().map(PersonDto::new).collect(Collectors.toList());
	}
	
	public static class  PersonDto{
		private final String name;
		private final String city;
		public PersonDto(Person person){
			this.name=person.getFirstName()+" "+person.getLastName();
			this.city=person.getCity();
		}
		@Override
		public String toString() {
			return name +" from "+ city;
		}
		
	}
	
	
	
}


