package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.TemperatureAndHumidityMapper;
import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.pojo.waterData;
import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    @Autowired
    private TemperatureAndHumidityMapper mapper;

    @Override
    public List<waterData> queryWater() {
        return mapper.queryWater();
    }

    @Override
    public List<Temperatureandhumiditysensordata> queryTemper() {
        return mapper.queryTemper();
    }

    @Override
    public List<Humiditysensordata> queryHumidity() {
        return mapper.queryHumidity();
    }

    @Override
    public void insert(Temperatureandhumiditysensordata data) {
        mapper.insert(data);
    }
}
