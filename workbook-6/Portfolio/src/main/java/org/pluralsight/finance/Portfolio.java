package org.pluralsight.finance;

import org.pluralsight.FixedAsset;
import org.pluralsight.Valuable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Portfolio
{

    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner)
    {
        this.name = name;
        this.owner = owner;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }


    public void add(Valuable asset)
    {
        assets.add(asset);
    }
    public Valuable getMostValuable()
    {
        if (assets.isEmpty()) {
            return null;
        }
        Valuable mostValuable = assets.getFirst();
        for (Valuable asset : assets) {
            if (asset.getValue() > mostValuable.getValue()) {
                mostValuable = asset;
            }
        }
        return mostValuable;

    }

    public Valuable getLeastValuable()
    {
        if (assets.isEmpty()) {
            return null;
        }
        Valuable leastValuable = assets.getFirst();
        for (Valuable asset : assets) {
            if (asset.getValue() < leastValuable.getValue()) {
                leastValuable = asset;
            }
        }
        return leastValuable;
    }

    public double getValue()
    {
        double totalValue = 0;
        for (Valuable asset : assets) {
            totalValue += asset.getValue();
        }
        return totalValue;
    }
}
