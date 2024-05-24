package com.example.demo.mapper;

import com.example.demo.pojo.Temperatureandhumiditysensordata;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface TemperatureAndHumidityMapper {
    List<Temperatureandhumiditysensordata> queryAll();
    void insert(Temperatureandhumiditysensordata data);
}
