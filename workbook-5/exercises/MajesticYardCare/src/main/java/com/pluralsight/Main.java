package com.pluralsight;

import com.pluralsight.models.Shape;
import com.pluralsight.services.ShapeFileManager;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Shape> shapes = new ArrayList<>();
        ShapeFileManager file = new ShapeFileManager();

        // load all shapes into the arraylist
        shapes = file.loadAccounts();

        // then print the toString() of each shape
        for (Shape shape: shapes)
        {
            System.out.println(shape);
        }
    }
}