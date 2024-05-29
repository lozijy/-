package com.example.demo.Manager;

import com.alibaba.fastjson.JSON;
import com.example.demo.Handler.MyWebSocketHandler;
import com.example.demo.domain.RandomResult;
import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.service.SensorService;
import com.example.demo.util.DatabaseUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
@JsonIgnoreProperties(ignoreUnknown = true)
public class HumiditySensor implements Runnable {
    private static final Random random = new Random();
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private int sensorId;
    private int interval; // 传感器数据生成的时间间隔（毫秒）
    private SensorService service;

    public HumiditySensor(int sensorId, int interval) {
        this.sensorId = sensorId;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            double humidity = generateRandomHumidity();
            double temperature=generateRandomTemperature();
            Date utilDate = new Date();
            java.sql.Date timestamp = new java.sql.Date(utilDate.getTime());
            // 构建传感器数据
            Humiditysensordata sensorData = new Humiditysensordata(sensorId, humidity,temperature, timestamp);
            // 发送传感器数据（这里使用打印输出代替实际发送）
            //userName怎么获取
//            System.out.println(JSON.toJSONString(sensorData));
            MyWebSocketHandler.sendToAll(JSON.toJSONString(sensorData));
            DatabaseUtils.saveSensorData(sensorData);
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
        double meanTemperature = 20 + 5 * Math.sin(angle);

        // 生成随机温度值,并保留两位小数
        double randomValue = new RandomResult(meanTemperature, 0.04).result();
        return Math.round(randomValue * 100.0) / 100.0;
    }
    private double generateRandomHumidity() {
        // 生成介于20.0到30.0之间的随机温度值
        double randomValue = new RandomResult(0.65, 0.01).result();
        return Math.round(randomValue * 100.0) / 100.0;
    }
}