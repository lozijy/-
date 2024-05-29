package com.example.demo.service;

import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.pojo.waterData;
import com.example.demo.util.DatabaseUtils;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SensorService {


    List<waterData> queryWater();
    List<Temperatureandhumiditysensordata> queryTemper();
    List<Humiditysensordata> queryHumidity();

    void insert(Temperatureandhumiditysensordata data);

    public double[] getKong_wen();
    public double[] getTu_wen();
    public double[] getTu_hu();
    public double[] getKong_hu();
    public double[] get_Dan();
    public double[] get_P();
    public double[] get_Conductivity();
    public double[] get_PH();
}