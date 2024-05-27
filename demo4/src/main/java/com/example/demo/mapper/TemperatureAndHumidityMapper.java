package com.example.demo.mapper;

import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.pojo.waterData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface TemperatureAndHumidityMapper {
    List<Temperatureandhumiditysensordata> queryTemper();
    List<waterData> queryWater();
    List<Humiditysensordata> queryHumidity();
    void insert(Temperatureandhumiditysensordata data);
}
