package com.example.demo.Manager;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SensorManager {
    private static final int NUM_SENSORS = 3; // 传感器数量
    private static final int DATA_INTERVAL = 1000; // 传感器数据生成的时间间隔（毫秒）

    private ExecutorService executorService;
    private List<HumiditySensor> humiditySensors;
    private List<HumidityAndTemperatureSensor> humidityAndTemperatureSensors;

    private List<WaterSensor>waterSensors;
    @PostConstruct
    public void init() {
        executorService = Executors.newFixedThreadPool(NUM_SENSORS);
        executorService = Executors.newFixedThreadPool(NUM_SENSORS);
        humidityAndTemperatureSensors = new ArrayList<>();
        humiditySensors = new ArrayList<>();
        waterSensors = new ArrayList<>();
        for (int i = 1; i <= NUM_SENSORS; i++) {
            HumiditySensor humiditySensor = new HumiditySensor(i, DATA_INTERVAL);
            HumidityAndTemperatureSensor humidityAndTemperatureSensor =new HumidityAndTemperatureSensor(i,DATA_INTERVAL);
            humiditySensors.add(humiditySensor);
            humidityAndTemperatureSensors.add(humidityAndTemperatureSensor);
            executorService.execute(humiditySensor);
            executorService.execute(humidityAndTemperatureSensor);

            WaterSensor waterSensor = new WaterSensor( DATA_INTERVAL);
            waterSensors.add(waterSensor);
            executorService.execute(waterSensor);
        }
    }

    // 其他方法和逻辑...

    // 在应用程序关闭时停止传感器线程
    @PreDestroy
    public void cleanup() {
        executorService.shutdown();
    }
}