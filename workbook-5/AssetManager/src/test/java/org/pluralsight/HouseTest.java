package org.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest
{


    @Test
    void whenOGValueIs200000_CondiitonIsExcellent_getValue()
    {
        House house = new House("Beautiful house", 200000.00, "null", "null",
                1, 2000, 1500);

        double expected = (180.00 * 1500) + (0.25 * 2000);

        assertEquals(expected, house.getValue());

    }

    @Test
    void whenOGValueIs200000_CondiitonIsGood_getValue(){
        House house = new House("Good house", 200000.00, "null", "null",
                2, 2000, 1800);

        double expected = (130.00 * 1800) + (0.25 * 2000);

        assertEquals(expected, house.getValue());
    }
    @Test
    void whenOGValueIs200000_CondiitonIsFair_getValue(){
        House house = new House("Okay house", 200000.00, "null", "null",
                3, 1800, 1200);

        double expected = (90.00 * 1200) + (0.25 * 1800);

        assertEquals(expected, house.getValue());
    }

    @Test
    void whenOGValueIs200000_CondiitonIsPoor_getValue(){
        House house = new House("FixerUpper house", 200000.00, "null", "null",
                4, 1500, 1100);

        double expected = (80.00 * 1100) + (0.25 * 1500);

        assertEquals(expected, house.getValue());
    }


}