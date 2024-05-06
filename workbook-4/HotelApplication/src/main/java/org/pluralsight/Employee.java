package org.pluralsight;

public class Employee
{
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(int employeeId, double hoursWorked, double payRate, String department, String name)
    {
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
        this.department = department;
        this.name = name;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
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

    public double getPayRate()
    {
        return payRate;
    }

    public void setPayRate(double payRate)
    {
        this.payRate = payRate;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeHours(){
        double overtime = 0;
        if(getHoursWorked() > 40){
            overtime = getHoursWorked() - 40;

        }
        return overtime;
    }

    public double getRegularHours(){
        double regular = 0;
        if(getHoursWorked() <= 40) {
            regular = getHoursWorked() * getPayRate();
        }
        else {
            regular = 40 * getPayRate();
        }

      return regular;
    }

    public double getTotalPay(){
        if(getOvertimeHours() != 0)
        {
            
        }
        return getOvertimeHours() + getRegularHours();
    }
}
