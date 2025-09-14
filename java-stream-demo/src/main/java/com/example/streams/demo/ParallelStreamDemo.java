package com.example.streams.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.example.streams.model.*;


public class ParallelStreamDemo {

	private final List<Person> people;
	public ParallelStreamDemo(List<Person> people) {
		this.people=people;
	}
	
	public void demonstrateParallelVsSequential() {
		
		System.out.println("Number of Processors: "+Runtime.getRuntime().availableProcessors());
		
		long startTime=System.nanoTime();
		List<String> sequentialResultStrings=people.stream().filter(p->p.getSalary()>50000).map(p->{simulateExpensiveOperation(); return p.getLastName().toUpperCase();} ).collect(Collectors.toList());
		long sequentialTime = TimeUnit.NANOSECONDS.toMillis(
	            System.nanoTime() - startTime);
		
		
		
		
		
	}
	
	private void simulateExpensiveOperation() {
        try {
            Thread.sleep(10); // Simulate expensive operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
	
	
	
	
}
