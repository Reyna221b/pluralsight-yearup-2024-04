package com.pluralsight.services;

import com.pluralsight.models.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShapeFileManager
{
    public static ArrayList<Shape> loadAccounts()
    {
        ArrayList<Shape> shapes = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File("data/shapes.csv")))
        {
            int width, height;
            Shape shape = null;

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] tokens = line.split("\\|");

                String type = tokens[0];

                switch (type){
                    case "circle":
                        int measurement = Integer.parseInt(tokens[1]);
                        shape = new Circle(measurement);
                        shapes.add(shape);
                        break;
                    case "rectangle":
                        width = Integer.parseInt(tokens[1]);
                        height = Integer.parseInt(tokens[2]);
                        shape = new Rectangle(width,height);
                        shapes.add(shape);
                        break;
                    case "square":
                        width = Integer.parseInt(tokens[1]);
                        shape = new Square(width);
                        shapes.add(shape);
                        break;
                    case"triangle":
                        width = Integer.parseInt(tokens[1]);
                        height = Integer.parseInt(tokens[2]);
                        shape = new Triangle(width,height);
                        shapes.add(shape);
                        break;
                }
                System.out.println(shape);

            }
        }
        catch (IOException e)
        {

        }

        return shapes;
    }
}
