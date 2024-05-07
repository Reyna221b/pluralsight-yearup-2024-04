package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GuestHistory
{
    private ArrayList<Reservation> reservations;

    public GuestHistory()
    {
        loadReservationHistory();
    }

    private void loadReservationHistory()
    {
        reservations = new ArrayList<>();

        File file = new File("files/reservations.csv");
        try(Scanner fileScanner = new Scanner(file))
        {
            fileScanner.nextLine();

            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] tokens = line.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String firstName = tokens[1];
                String lastName = tokens[2];
                LocalDate reservationDate = LocalDate.parse(tokens[3]);
                int roomNumber = Integer.parseInt(tokens[4]);

                Reservation reservation = new Reservation(id, firstName, lastName, reservationDate, roomNumber);
                reservations.add(reservation);
            }

        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        Collections.sort(reservations, new Comparator<Reservation>() {
            @Override
            public int compare(Reservation r1, Reservation r2) {
                return r1.getReservationDate().compareTo(r2.getReservationDate());
            }
        });
    }

    public ArrayList<Reservation> getAllReservations()
    {
        return reservations;
    }

    public ArrayList<Reservation> searchForGuest(int roomNumber)
    {
        return searchForGuest(null, null, null, roomNumber);
    }

    public ArrayList<Reservation> searchForGuest(LocalDate reservationDate)
    {
        return searchForGuest(null, null, reservationDate, null);
//        return (ArrayList<Reservation>) reservations.stream()
//                                                    .filter(res -> res.getReservationDate().equals(reservationDate))
//                                                    .collect(Collectors.toList());
    }

    public ArrayList<Reservation> searchForGuest(String lastName)
    {
        ArrayList<Reservation> filtered =  (ArrayList<Reservation>) reservations.stream()
                                                                                .filter(reservation -> reservation.getLastName().equalsIgnoreCase(lastName))
                                                                                .collect(Collectors.toList());

        ArrayList<Reservation> filteredReservations = new ArrayList<>();

        for(Reservation reservation : reservations)
        {
            if(reservation.getLastName().equals(lastName))
            {
                filteredReservations.add(reservation);
            }
        }

        return filteredReservations;

    }

    public ArrayList<Reservation> searchForGuest(String lastName, String firstName, LocalDate reservationDate, Integer roomNumber)
    {
        ArrayList<Reservation> filtered =  (ArrayList<Reservation>) reservations.stream()
                                                                                .filter(r -> lastName == null || r.getLastName().equalsIgnoreCase(lastName))
                                                                                .filter(r -> firstName == null || r.getLastName().equalsIgnoreCase(firstName))
                                                                                .filter(r -> reservationDate == null || r.getReservationDate().equals(reservationDate))
                                                                                .filter(r -> roomNumber == null || r.getRoom().getRoomNumber() == roomNumber)
                                                                                .collect(Collectors.toList());

        return filtered;
//
//        ArrayList<Reservation> filteredReservations = new ArrayList<>();
//
//        for(Reservation reservation : reservations)
//        {
//            if(reservation.getLastName().equals(lastName))
//            {
//                filteredReservations.add(reservation);
//            }
//        }
//
//        return filteredReservations;

    }
}
