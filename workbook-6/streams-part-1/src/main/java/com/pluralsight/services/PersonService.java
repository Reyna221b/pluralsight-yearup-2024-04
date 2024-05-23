package com.pluralsight.services;

import com.pluralsight.models.Employee;
import com.pluralsight.models.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService
{

    public List<Person> findPeople(List<Person> people, String name)
    {
        // search for people by first name
        // return a new List<Person> with the search results

        List<Person> personByName = new ArrayList<>();
        for(Person p: people)
        {
            if(p.getFirstName().equalsIgnoreCase(name)){
                personByName.add(p);
            }
        }
        return personByName;
    }

    public List<Person> findPeople(List<Person> people, int age)
    {
        List<Person> personByAge = new ArrayList<>();
        for(Person p: people)
        {
            if(p.getAge() == age){
                personByAge.add(p);
            }
        }
        return personByAge;
    }

    public int calculateAverageAge(List<Person> people)
    {
        int avgAge = 0;
        for(Person p : people)
        {
            avgAge += p.getAge();
        }
        return people.isEmpty() ? 0 : avgAge/ people.size();
    }

    public int findOldestAge(List<Person> people)
    {
        int oldest = 0;
        for(Person p : people){
            if(p.getAge() > oldest){
                oldest = p.getAge();
            }
        }
        return oldest;
    }

    public int findYoungestAge(List<Person> people)
    {
        int youngest = Integer.MAX_VALUE;
        for(Person p : people){
            if(p.getAge() < youngest){
                youngest = p.getAge();
            }
        }
        return youngest;
    }

    public List<Person> sortYoungestFirst(List<Person> people)
    {

        List<Person> youngestSorted = new ArrayList<>(people);
        Collections.sort(youngestSorted, Comparator.comparingInt(Person::getAge));
        return youngestSorted;
    }

    public List<Person> sortOldestFirst(List<Person> people)
    {
        List<Person> oldestSorted = new ArrayList<>(people);
        Collections.sort(oldestSorted, Comparator.comparingInt(Person::getAge).reversed());
        return oldestSorted;
    }

    public List<Employee> createEmployees(List<Person> people)
    {
        // populate the list of Employees with...
        // create a new Employee for each person in your people list
        // the salary of each employee is based on their age $3,000 per year
        // i.e. a 10 year old = $30,000, a 40 year old = $120,000 etc
        List<Employee> employees = new ArrayList<>();
        for(Person p: people){
            double salary = p.getAge()* 3000;
            employees.add(new Employee(p.getFirstName(),p.getLastName(),p.getAge(), salary));
        }

        return employees;
    }
}
