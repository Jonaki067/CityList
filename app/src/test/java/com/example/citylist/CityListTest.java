package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    @Test
    public void testDelete() {
        CityList cityList = new CityList();
        City city1= new City("Dhaka", "CD");
        City city2= new City("Regina", "SK");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertTrue(!cityList.getCities(0).contains(city1));
        assertEquals(1, cityList.getCities(0).size());
    }

    @Test
    public void testCount() {
        CityList cityList = new CityList();
        City city1= new City("Dhaka", "CD");
        City city2= new City("Regina", "SK");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);

        assertEquals(cityList.count(), cityList.getCities(0).size());
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDeleteException() {
        CityList cityList=new CityList();

        City city1= new City("Edmonton", "AB");
        City city2= new City("Regina", "SK");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList=new CityList();

        City city1= new City("Dhaka", "CD");
        City city2= new City("Regina", "SK");
        City city3= new City("Barishal", "EF");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        assertEquals(0, city3.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(0).get(1)));
        assertEquals(0, city2.compareTo(cityList.getCities(0).get(2)));

        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city3.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0, city2.compareTo(cityList.getCities(1).get(2)));
    }
}