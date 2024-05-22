package com.pluralsight.models;

public class Triangle extends Shape
{
    private int base;
    private int height;

    public Triangle(int base, int height)
    {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    public int getBase()
    {
        return base;
    }

    public int getHeight()
    {
        return height;
    }

    @Override
    public double getArea()
    {
        return (base * height)/2.00;
    }

    @Override
    public String toString()
    {
        return String.format("%s (base: %d, height: %d): %.2f", getName(), base, height, getArea());
    }
}
