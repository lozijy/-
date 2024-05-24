package com.example.demo.controller;

import com.example.demo.domain.JsonResult;
import com.example.demo.pojo.FarmingMachinery;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.service.MachineryService;
import com.example.demo.service.SensorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/15:59
 * @Description:
 */
@Controller
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的

@RequestMapping(value = "/machinery")
public class machineryController {
    @Autowired
    private MachineryService service;
    @ApiOperation("查询所有农机")
    @GetMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(){
        List<FarmingMachinery> data = service.queryAll();
        return new JsonResult<>(data);
    }
    @ApiOperation("查询农机信息")
    @GetMapping("/queryById/{Id}")
    @ResponseBody
    public JsonResult queryById(@PathVariable("Id")Integer Id){
        return new JsonResult<>(service.queryById(Id));
    }

    @ApiOperation("删除农机")
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")Integer id){
        service.delete(id);
        return "删除成功";
    }

    @ApiOperation("添加农机")
    @PostMapping("/insert")
    @ResponseBody
    public String add(@RequestBody FarmingMachinery ma){
        System.out.println(ma);
        service.insert(ma);
        return "添加OK";
    }
    //Put请求
    @ApiOperation("修改农机信息")
    @PutMapping("/update")
    @ResponseBody
    public String updateInfo(@RequestBody FarmingMachinery ma){
        service.update(ma);
        return "修改成功";
    }
    @ApiOperation("查询用户的所有农机信息信息")
    @GetMapping("/quertByOwnerId/{ownerId}")
    @ResponseBody
    public JsonResult queryByOwnerId(@PathVariable("ownerId")Integer ownerId){
        return new JsonResult<>(service.queryById(ownerId));
    }

}

