package com.example.demo.service;

import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.pojo.waterData;

import java.util.List;

public interface SensorService {

    List<waterData> queryWater();
    List<Temperatureandhumiditysensordata> queryTemper();
    List<Humiditysensordata> queryHumidity();

    void insert(Temperatureandhumiditysensordata data);
}