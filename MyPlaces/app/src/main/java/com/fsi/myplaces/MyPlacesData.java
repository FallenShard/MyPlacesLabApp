package com.fsi.myplaces;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by FallenShard on 4/26/2015.
 */
public class MyPlacesData
{
    private ArrayList<MyPlace> myPlaces;

    private MyPlacesData()
    {
        myPlaces = new ArrayList<>();
        myPlaces.add(new MyPlace("Place A"));
        myPlaces.add(new MyPlace("Place B"));
        myPlaces.add(new MyPlace("Place C"));
        myPlaces.add(new MyPlace("Place D"));
        myPlaces.add(new MyPlace("Place E"));
    }

    private static class SingletonHolder
    {
        public static final MyPlacesData instance = new MyPlacesData();
    }

    public static MyPlacesData getInstance()
    {
        return SingletonHolder.instance;
    }

    public ArrayList<MyPlace> getMyPlaces()
    {
        return myPlaces;
    }

    public void addNewPlace(MyPlace myPlace)
    {
        myPlaces.add(myPlace);
    }

    public MyPlace getPlace(int index)
    {
        return myPlaces.get(index);
    }

    public void deletePlace(int index)
    {
        myPlaces.remove(index);
    }
}
