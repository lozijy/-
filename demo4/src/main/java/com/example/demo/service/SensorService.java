package com.example.demo.service;

import com.example.demo.pojo.Temperatureandhumiditysensordata;

import java.util.List;

public interface SensorService {

    List<Temperatureandhumiditysensordata> queryAll();

    void insert(Temperatureandhumiditysensordata data);
}