package com.example.demo.Manager;
import com.alibaba.fastjson.JSON;
import com.example.demo.Handler.MyWebSocketHandler;
import com.example.demo.domain.RandomResult;
import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.pojo.waterData;
import com.example.demo.service.SensorService;
import com.example.demo.util.DatabaseUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/22:37
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterSensor implements Runnable {
    private static final Random random = new Random();
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private int interval; // 传感器数据生成的时间间隔（毫秒）
    private SensorService service;

    public WaterSensor( int interval) {
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            double P = generateRandomP();
            double PH= generateRandomPH();
            double Con=generateRandomConductivity();
            double Ni= generateRandomNitrogen();

            Date utilDate = new Date();
            java.sql.Date timestamp = new java.sql.Date(utilDate.getTime());
            // 构建传感器数据
            waterData waterdata = new waterData(timestamp,PH,Con,P,Ni);
            // 发送传感器数据（这里使用打印输出代替实际发送）
            //userName怎么获取
//            System.out.println(JSON.toJSONString(waterdata));
            MyWebSocketHandler.sendToAll(JSON.toJSONString(waterdata));
            DatabaseUtils.saveWaterData(waterdata);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private double generateRandomP() {
        // 生成介于20.00到30.00之间的随机温度值
        double randomValue= new RandomResult(0.05, 0.005).result();
        return Math.round(randomValue * 100.0) / 100.0;
    }

    private double generateRandomPH() {
        // 生成介于6.50到7.00之间的随机温度值
        double randomValue=new RandomResult(6.50, 0.05).result();
        return Math.round(randomValue * 100.0) / 100.0;
    }

    private double generateRandomConductivity() {
        double randomValue= new RandomResult(0.20, 0.005).result();
        return Math.round(randomValue * 100.0) / 100.0;
    }

    private double generateRandomNitrogen() {
        // 生成介于0.25到0.30之间的随机温度值
        double randomValue= new RandomResult(0.25, 0.005).result();
        return Math.round(randomValue * 100.0) / 100.0;
    }
    }
