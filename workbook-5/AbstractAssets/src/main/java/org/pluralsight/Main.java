package org.pluralsight;

import java.util.ArrayList;

public class Main
{ public static void main(String[] args)
{
    ArrayList<Asset> assets = new ArrayList<>();
    assets.add(new House("My Childhood Home", 140000.0, "2007",
            "Phx,Az", 3,2800,1800));
    assets.add(new House("vacation Home", 180000.44,"2017",
            "Somewhere by a lake",4, 3000, 2000));
    assets.add(new Vehicle("Sister's Car", 20000,"2015",
            "Honda Civic",2014,110010));

    for (Asset asset: assets)
    {
        getValue(asset);
    }

}


    public static void getValue(Asset asset){
        double message = asset.getValue();

        if(asset instanceof House)
        {
            House miniHouse = (House) asset;
            System.out.println("House value now: " + miniHouse.getValue());
        } else if (asset instanceof Vehicle)
        {
            Vehicle car = (Vehicle) asset;

            System.out.printf("Car value now: %.2f",car.getValue());
        }

    }
}