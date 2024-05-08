package org.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest
{


    @Test
    public void ifCleanAndUnoccupied_WhenCheckedIn_ThenRoomShouldBeDirtyAndOccupied()
    {
        //arrange
        Room test = new Room(10,false, false, 139);

        //ACT
        //check in should check if room is unoccupied and not dirty.

        test.checkIn();

        //Assert
        assertTrue(test.isOccupied());
        assertTrue(test.isDirty());
    }

    @Test
    public void ifCheckedOut_RoomShouldBe_CleanAndUnoccupied()
    {
        //arrange
        Room test = new Room(10,true, true, 139);

        //ACT
        //check in to make rooms occupied and dirty

        test.checkOut();

        //Assert
        assertFalse(test.isOccupied());
        assertFalse(test.isDirty());

    }

    @Test
    public void ifUnoccupiedButDirtyRoom_ThenCleanRoom_RoomShouldBeClean(){
        //Arrange
        Room test = new Room(10,true, false, 139);

        //Act
        test.cleanRoom();

        //Assert
        assertFalse(test.isDirty());

    }

    @Test
    public void ifOccupiedRoom_ThenCleanRoom_RoomShouldRemainDirty()
    {
        //Arrange
        //testing to see when isOccupied is set to true but room is dirty (true)
        //if my cleanRoom function will leave the room dirty.
        //Expected outcome should be room to still be dirty (room should be True)
        Room test = new Room(10,true, true, 139);

        //Act
        test.cleanRoom();

        //Assert
        assertTrue(test.isDirty());
    }

    @Test
    public void ifRoomIsCleanAndUnoccupied_checkingAvailability_RoomIsAvailable()
    {
        Room test = new Room(10,false, false, 139);
        assertTrue(test.isAvailable());
    }

    @Test
    public void ifRoomOccupied_CheckingAvailability_RoomIsNotAvailable()
    {
        Room test = new Room(10,false, true, 139);
        assertFalse(test.isAvailable());
    }

    @Test
    public void ifRoomDirty_checkAvailability_RoomIsNotAvailable()
    {
        Room test = new Room(10,true, false, 139);
        assertFalse(test.isAvailable());
    }

}