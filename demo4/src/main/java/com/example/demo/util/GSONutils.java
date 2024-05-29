package com.example.demo.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/29/15:57
 * @Description:
 */
public class GSONutils {
    public  static ResponseEntity<String> GsonConstructor(double[]tu_shi,double[] kong_shi,String Type){
        // 创建 JsonObject 并填充数据
        JsonObject jsonObject = new JsonObject();
        JsonObject data = new JsonObject();

        // 填充 datetime 数组
        JsonArray datetimeArray = new JsonArray();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH");

        // 从当前时间的整点到前 3 天的整点时间点,以 2 小时为间隔

            LocalDateTime day = now.minusDays(1);
            for (int j = 0; j < 13; j++) {
                datetimeArray.add(day.format(formatter));
                day = day.plusHours(2);
            }

        data.add("categories", datetimeArray);

        // 填充 series 数组
        JsonArray seriesArray = new JsonArray();

        // 土壤温度
        JsonObject soilTempSeries = new JsonObject();
        soilTempSeries.addProperty("name", "土壤"+Type);
        JsonArray soilTempData = new JsonArray();
        for (int i = 0; i < tu_shi.length; i++) {
            soilTempData.add(tu_shi[i]);
        }
        soilTempSeries.add("data", soilTempData);
        seriesArray.add(soilTempSeries);

        // 土壤湿度
        JsonObject soilHumiditySeries = new JsonObject();
        soilHumiditySeries.addProperty("name", "空气"+Type);
        JsonArray soilHumidityData = new JsonArray();
        for (int i = 0; i < tu_shi.length; i++) {
            soilHumidityData.add(kong_shi[i]);
        }
        soilHumiditySeries.add("data", soilHumidityData);
        seriesArray.add(soilHumiditySeries);

        data.add("series", seriesArray);
        jsonObject.add("data", data);
        jsonObject.addProperty("code",200);
        jsonObject.addProperty("msg","获取成功");

        // 将 JsonObject 转换为 JSON 字符串并返回
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(jsonObject);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }
    public static ResponseEntity<String> GsonDanConstructor(double[]dan,double[]P){
        // 创建 JsonObject 并填充数据
        JsonObject jsonObject = new JsonObject();
        JsonObject data = new JsonObject();

        // 填充 datetime 数组
        JsonArray datetimeArray = new JsonArray();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH");

        // 从当前时间的整点到前 3 天的整点时间点,以 2 小时为间隔

        LocalDateTime day = now.minusDays(1);
        for (int j = 0; j < 13; j++) {
            datetimeArray.add(day.format(formatter));
            day = day.plusHours(2);
        }

        data.add("categories", datetimeArray);

        // 填充 series 数组
        JsonArray seriesArray = new JsonArray();

        // 土壤温度
        JsonObject soilTempSeries = new JsonObject();
        soilTempSeries.addProperty("name","氮含量");
        JsonArray soilTempData = new JsonArray();
        for (int i = 0; i < dan.length; i++) {
            soilTempData.add(dan[i]);
        }
        soilTempSeries.add("data", soilTempData);
        seriesArray.add(soilTempSeries);

        // 土壤湿度
        JsonObject soilHumiditySeries = new JsonObject();
        soilHumiditySeries.addProperty("name", "磷含量");
        JsonArray soilHumidityData = new JsonArray();
        for (int i = 0; i < P.length; i++) {
            soilHumidityData.add(P[i]);
        }
        soilHumiditySeries.add("data", soilHumidityData);
        seriesArray.add(soilHumiditySeries);

        data.add("series", seriesArray);
        jsonObject.add("data", data);
        jsonObject.addProperty("code",200);
        jsonObject.addProperty("msg","获取成功");

        // 将 JsonObject 转换为 JSON 字符串并返回
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(jsonObject);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

    }
    public static ResponseEntity<String> GsonPHConstructor(double[]PH){
        // 创建 JsonObject 并填充数据
        JsonObject jsonObject = new JsonObject();
        JsonObject data = new JsonObject();

        // 填充 datetime 数组
        JsonArray datetimeArray = new JsonArray();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH");

        // 从当前时间的整点到前 3 天的整点时间点,以 2 小时为间隔

        LocalDateTime day = now.minusDays(1);
        for (int j = 0; j < 13; j++) {
            datetimeArray.add(day.format(formatter));
            day = day.plusHours(2);
        }

        data.add("categories", datetimeArray);

        // 填充 series 数组
        JsonArray seriesArray = new JsonArray();

        // 土壤温度
        JsonObject soilTempSeries = new JsonObject();
        soilTempSeries.addProperty("name","PH值");
        JsonArray soilTempData = new JsonArray();
        for (int i = 0; i < PH.length; i++) {
            soilTempData.add(PH[i]);
        }
        soilTempSeries.add("data", soilTempData);
        seriesArray.add(soilTempSeries);



        data.add("series", seriesArray);
        jsonObject.add("data", data);
        jsonObject.addProperty("code",200);
        jsonObject.addProperty("msg","获取成功");

        // 将 JsonObject 转换为 JSON 字符串并返回
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(jsonObject);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

    }
    public static ResponseEntity<String> GsonConConstructor(double[]Con){
        // 创建 JsonObject 并填充数据
        JsonObject jsonObject = new JsonObject();
        JsonObject data = new JsonObject();

        // 填充 datetime 数组
        JsonArray datetimeArray = new JsonArray();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH");

        // 从当前时间的整点到前 3 天的整点时间点,以 2 小时为间隔

        LocalDateTime day = now.minusDays(1);
        for (int j = 0; j < 13; j++) {
            datetimeArray.add(day.format(formatter));
            day = day.plusHours(2);
        }

        data.add("categories", datetimeArray);

        // 填充 series 数组
        JsonArray seriesArray = new JsonArray();

        // 土壤温度
        JsonObject soilTempSeries = new JsonObject();
        soilTempSeries.addProperty("name","电导率");
        JsonArray soilTempData = new JsonArray();
        for (int i = 0; i < Con.length; i++) {
            soilTempData.add(Con[i]);
        }
        soilTempSeries.add("data", soilTempData);
        seriesArray.add(soilTempSeries);



        data.add("series", seriesArray);
        jsonObject.add("data", data);
        jsonObject.addProperty("code",200);
        jsonObject.addProperty("msg","获取成功");

        // 将 JsonObject 转换为 JSON 字符串并返回
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(jsonObject);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }
}
