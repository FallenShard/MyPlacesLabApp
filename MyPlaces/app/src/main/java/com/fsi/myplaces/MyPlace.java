package com.fsi.myplaces;

/**
 * Created by FallenShard on 4/26/2015.
 */
public class MyPlace
{
    private String name;
    private String description;

    public MyPlace()
    {
    }

    public MyPlace(String name)
    {
        this.name = name;
        this.description = "";
    }

    public MyPlace(String name, String desc)
    {
        this.name = name;
        this.description = desc;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String desc)
    {
        this.description = desc;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
