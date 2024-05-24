package com.example.demo.Manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.Handler.MyWebSocketHandler;
import com.example.demo.domain.RandomResult;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.service.SensorService;
import com.example.demo.util.DatabaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class HumidityAndTemperatureSensor implements Runnable {
    private static final Random random = new Random();
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private int sensorId;
    private int interval; // 传感器数据生成的时间间隔（毫秒）

    public HumidityAndTemperatureSensor(int sensorId, int interval) {
        this.sensorId = sensorId;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            double temperature = generateRandomTemperature();
            double humidity = generateRandomHumidity();
            Date utilDate = new Date();
            java.sql.Date timestamp = new java.sql.Date(utilDate.getTime());
            // 构建传感器数据
            Temperatureandhumiditysensordata sensorData = new Temperatureandhumiditysensordata(sensorId, temperature, humidity, timestamp);

            // 发送传感器数据（这里使用打印输出代替实际发送）
//            System.out.println(JSON.toJSONString(sensorData));
            MyWebSocketHandler.sendToAll(JSON.toJSONString(sensorData));
//            // 存储到数据库
//            DatabaseUtils.saveSensorData(sensorData);


            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private double generateRandomTemperature() {
        // 获取当前系统时间
// 获取当前系统时间
        long currentTime = System.currentTimeMillis();

// 获取当日零点的时间戳
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long midnightTime = calendar.getTimeInMillis();

// 计算当前时间与当日零点的时间差
        long timeDifference = currentTime - midnightTime;

// 计算正弦函数中的角度,使用周期为24小时的正弦函数
        double angle = (timeDifference / (1000.0 * 60 * 60 * 24)) * 2 * Math.PI+Math.PI*1.5;
//        System.out.println(angle);
        // 计算温度均值,使用幅度为2度的正弦函数
        double meanTemperature = 25 + 5 * Math.sin(angle);

        // 生成随机温度值,并保留两位小数
        double randomValue = new RandomResult(meanTemperature, 0.04).result();
        return Math.round(randomValue * 100.0) / 100.0;
    }

    private double generateRandomHumidity() {
        double randomValue = new RandomResult(0.75, 0.005).result();
        return Math.round(randomValue * 100.0) / 100.0;
    }

}