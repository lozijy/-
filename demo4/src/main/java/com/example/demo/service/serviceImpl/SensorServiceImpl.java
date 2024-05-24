package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.TemperatureAndHumidityMapper;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    @Autowired
    private TemperatureAndHumidityMapper mapper;

    @Override
    public List<Temperatureandhumiditysensordata> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public void insert(Temperatureandhumiditysensordata data) {
        mapper.insert(data);
    }
}
