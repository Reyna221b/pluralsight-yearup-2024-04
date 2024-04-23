package org.pluralsight;

public class Employee
{
    private String employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(double payRate, double hoursWorked, String name, String employeeId)
    {
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate()
    {
        return payRate;
    }

    public void setPayRate(double payRate)
    {
        this.payRate = payRate;
    }

    public double getGrossPay()
    {
        return this.payRate * this.hoursWorked;
    }
}
