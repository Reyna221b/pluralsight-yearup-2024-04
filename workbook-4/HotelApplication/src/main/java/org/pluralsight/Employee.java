package org.pluralsight;

import java.time.LocalDateTime;

public class Employee
{
    private final double REGULAR_HOURS = 40;
    private final double OVERTIME_RATE =1.5;

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double shiftStartTime;
    private boolean isPunchedIn;

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

    public boolean isOverTimed()
    {
        return hoursWorked > REGULAR_HOURS;
    }

    public double getOvertimeHours()
    {

        return !isOverTimed() ? 0 : hoursWorked - REGULAR_HOURS;
    }

    public double getOvertimeHoursPay()
    {

        return getOvertimeHours() * getPayRate() * OVERTIME_RATE;
    }

    public double getRegularHours()
    {

        return isOverTimed() ?  REGULAR_HOURS : hoursWorked;
    }

    public double getRegularHoursPay()
    {
      return getRegularHours() * payRate;
    }

    public double getTotalPay()
    {
        return getOvertimeHours()+ getRegularHours();
    }

    public void punchIn(double time) {
        shiftStartTime = time;
    }
    public void punchOut(double time) {

        hoursWorked = time - shiftStartTime;
    }

    public void punchTimeCard(double time)
    {
        if(!isPunchedIn){
            shiftStartTime = time;
            isPunchedIn = true;
        }
        else {

            hoursWorked += time - shiftStartTime;
            isPunchedIn = false;
        }

    }
    public void punchTimeCard(LocalDateTime date)
    {

        int hours = date.getHour();
        double min = date.getMinute();
        double seconds = date.getSecond();

        double time = hours + (min/60.0) + (seconds/3600.0);
        punchTimeCard(time);
    }


}
