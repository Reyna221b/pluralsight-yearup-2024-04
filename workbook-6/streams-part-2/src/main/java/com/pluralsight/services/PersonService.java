package com.pluralsight.services;

import com.pluralsight.models.Employee;
import com.pluralsight.models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService
{

    public List<Person> findPeople(List<Person> people, String name)
    {
        // search for people by first name
        // return a new List<Person> with the search results

        List<Person> findByName = people.stream()
                                 .filter(person -> person.getFirstName().equalsIgnoreCase(name))
                                 .toList();
        return findByName;
    }

    public List<Person> findPeople(List<Person> people, int age)
    {
        List<Person> findByAge = people.stream()
                .filter(person -> person.getAge() == age)
                .toList();

        return findByAge;
    }

    public int calculateAverageAge(List<Person> people)
    {
        int average = 0;
        average = people.stream().mapToInt(Person::getAge).sum()/people.size();
        return average;

    }

    public int findOldestAge(List<Person> people)
    {
        int oldest = 0;

        oldest = people.stream()
                .mapToInt(Person::getAge)
                .reduce(oldest, Math::max);
        return oldest;

    }

    public int findYoungestAge(List<Person> people)
    {
        int youngest = Integer.MAX_VALUE;

        youngest = people.stream()
                .mapToInt(Person::getAge)
                .reduce(youngest, Math::min);
        return youngest;
    }

    public List<Person> sortYoungestFirst(List<Person> people)
    {
        return people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }

    public List<Person> sortOldestFirst(List<Person> people)
    {
        return people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());
    }

    public List<Employee> createEmployees(List<Person> people)
    {
        // populate the list of Employees with...
        // create a new Employee for each person in your people list
        // the salary of each employee is based on their age $3,000 per year
        // i.e. a 10 year old = $30,000, a 40 year old = $120,000 etc

        return people.stream()
                .map(person -> new Employee(
                        person.getFirstName(),
                        person.getLastName(),
                        person.getAge(),
                        person.getAge() * 3000
                ))
                .collect(Collectors.toList());

    }
}
