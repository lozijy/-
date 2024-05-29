package com.example.demo.controller;
import com.example.demo.util.GSONutils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.example.demo.domain.JsonResult;
import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.pojo.waterData;
import com.example.demo.service.SensorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/14:18
 * @Description:
 */
@Controller
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的

@RequestMapping(value = "/sensors")
public class sensorController {
    @Autowired
    private SensorService service;
    @ApiOperation("查询水传感器历史数据")
    @PostMapping ("/queryShui1")
    @ResponseBody
    public ResponseEntity<String> queryShui1() {
        double[] dan = service.get_Dan();
        double[] P = service.get_P();
        ResponseEntity<String> stringResponseEntity = GSONutils.GsonDanConstructor(dan,P);
        return stringResponseEntity;
    }
    @ApiOperation("查询水传感器历史数据")
    @PostMapping ("/queryShui2")
    @ResponseBody
    public ResponseEntity<String> queryShui2() {
        double[] Con = service.get_Conductivity();
        ResponseEntity<String> stringResponseEntity = GSONutils.GsonConConstructor(Con);
        return stringResponseEntity;
    }
    @ApiOperation("查询水传感器历史数据")
    @PostMapping ("/queryShui3")
    @ResponseBody
    public ResponseEntity<String> queryShui3() {
        double[] PH = service.get_PH();
        ResponseEntity<String> stringResponseEntity = GSONutils.GsonPHConstructor(PH);
        return stringResponseEntity;
    }
    @ApiOperation("查询湿度传感器历史数据")
    @PostMapping ("/queryShi")
    @ResponseBody
    public ResponseEntity<String> queryShi() throws SQLException {
        double[] tuHu = service.getTu_hu();
        double[] kongHu = service.getKong_hu();
        ResponseEntity<String> stringResponseEntity = GSONutils.GsonConstructor(tuHu, kongHu,"湿度");
        return stringResponseEntity;
    }
    @ApiOperation("查询空气传感器历史数据")
    @PostMapping ("/queryWen")
    @ResponseBody
    public ResponseEntity<String> queryWen() {
        // 原始 JSON 字符串
        double[] tu_wen = service.getTu_wen();
        double[] kong_wen = service.getKong_wen();
        ResponseEntity<String> stringResponseEntity = GSONutils.GsonConstructor(tu_wen, kong_wen,"温度");
        return stringResponseEntity;
    }



    @ApiOperation("查询水传感器历史数据")
    @GetMapping("/queryWater")
    @ResponseBody
    public JsonResult queryWater() {
        List<waterData> data = service.queryWater();
        return new JsonResult<>(data);
    }

    @ApiOperation("查询空气传感器历史数据")
    @GetMapping("/queryTemper")
    @ResponseBody
    public JsonResult queryTemper() {
        List<Temperatureandhumiditysensordata> data = service.queryTemper();
        return new JsonResult<>(data);
    }

    @ApiOperation("查询土壤传感器历史数据")
    @GetMapping("/queryHumidity")
    @ResponseBody
    public JsonResult queryHumidity() {
        List<Humiditysensordata> data = service.queryHumidity();
        return new JsonResult<>(data);
    }
}
