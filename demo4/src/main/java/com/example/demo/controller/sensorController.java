package com.example.demo.controller;

import com.example.demo.domain.JsonResult;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.service.SensorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ApiOperation("查询传感器历史数据")
    @GetMapping("queryAll")
    @ResponseBody
    public JsonResult queryAll(){
        List<Temperatureandhumiditysensordata> data = service.queryAll();
        return new JsonResult<>(data);
    }

}
