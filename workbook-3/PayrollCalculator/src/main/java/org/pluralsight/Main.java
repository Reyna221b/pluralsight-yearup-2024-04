package org.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<Employee> employees = new ArrayList<>();
    public static void main(String[] args)
    {
      loadEmployees();
      displayEmployee();
    }

    public static void loadEmployees()
    {
        File file = new File("files/employees.csv");

        try(Scanner fileScanner = new Scanner(file))
        {
            fileScanner.nextLine();

            while(fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();

                String[] columns = line.split("[|]");

                String id = columns[0];
                String name = columns[1];
                double hours = Double.parseDouble(columns[2]);
                double pay = Double.parseDouble(columns[3]);
                writeToFile(columns);

                Employee employee = new Employee(pay,hours,name,id);

                employees.add(employee);

            }
        }
        catch(IOException ex)
        {

        }
    }
    public static void displayEmployee()
    {
        System.out.println("Employee ID\t\tName\t\t\t\tGross Pay");
        System.out.println("-".repeat(55));
        for (Employee employee : employees) {
            System.out.printf("%5s\t\t\t%-19s $ %.2f", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            System.out.println();
        }
    }

    public static void writeToFile(String[] employeeFile)
    {
        File file = new File("files/payroll-2024.txt");

        try(FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter writer = new PrintWriter(fileWriter);
        )
        {
            writer.print("id|name|gross pay");
            writer.println();
            for(String line : employeeFile)
            {
                writer.print(line + "|");
            }
        }
        catch(IOException ex)
        {

        }
    }
}  