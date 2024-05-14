package org.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest
{

    @Test
    public void lessThan3Years_under100000Odometer()
    {
        Vehicle vehicle = new Vehicle("Car", 20000.00, "null", "Toyota Camry", 2021, 50000);
        double expectedValue = 20000.00 * Math.pow((1 - 0.03), 2024 - 2021);
        assertEquals(expectedValue, vehicle.getValue());
    }

    @Test
    public void between4And6Years_under100000Odometer()
    {
        Vehicle vehicle = new Vehicle("Car", 20000.00, "null", "Toyota Corolla", 2018, 80000);
        double expectedValue = 20000.00 * Math.pow((1 - 0.06), 2024 - 2018);
        assertEquals(expectedValue, vehicle.getValue());

    }

    @Test
    public void between7And10Years__under100000Odometer()
    {
        Vehicle vehicle = new Vehicle("Car", 20000.00, "null", "Honda Civic", 2015, 20000);
        double expectedValue = 20000.00 * Math.pow((1 - 0.08), 2024 - 2015);
        assertEquals(expectedValue, vehicle.getValue());
    }


    @Test
    public void moreThan10Years_under100000Odometer()
    {
        Vehicle vehicle = new Vehicle("Car", 20000.00, "null", "Ford Mustang", 2010, 10000);
        assertEquals(1000.00, vehicle.getValue());
    }

    @Test
    public void OdometerExceedsLimit()
    {
        Vehicle vehicle = new Vehicle("Car", 20000.00, "null", "Honda Accord", 2019, 100001);
        double valueBefore = 20000.00 * Math.pow((1 - 0.06), 2024 - 2019);

        double expectedValue = valueBefore - (valueBefore * 0.25);

        assertEquals(expectedValue, vehicle.getValue());
        
    }

}