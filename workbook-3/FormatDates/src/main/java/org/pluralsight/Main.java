package org.pluralsight;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.TimeZone;

public class Main
{
    public static void main(String[] args)
    {
        displayDate();
        dateAndTime();
    }
    public static void displayDate()
    {

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        System.out.println(today.format(formatter));
        System.out.println(today);
        formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(today.format(formatter));
        System.out.println();
    }

    public static void dateAndTime()
    {
        LocalDateTime today = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm z");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(today.format(formatter) );
    }

}