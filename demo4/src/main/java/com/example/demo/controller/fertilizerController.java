package com.example.demo.controller;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/17:15
 * @Description:
 */

import com.example.demo.domain.JsonResult;
import com.example.demo.pojo.Fertilizers;
import com.example.demo.service.fertilizersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的

@Controller
@RequestMapping(value = "/fertilization")
public class fertilizerController {
    @Autowired
    private fertilizersService service;
    @ApiOperation("查询肥料信息")
    @GetMapping("/queryById/{Id}")
    @ResponseBody
    public JsonResult queryById(@PathVariable("Id")Integer Id){
        return new JsonResult<>(service.queryById(Id));
    }
    @ApiOperation("查询所有肥料信息")
    @GetMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(){

        List<Fertilizers> data = service.queryAll();
        return new JsonResult<>(data);
    }
    @GetMapping("/lo")
    @ResponseBody
    public JsonResult quer(){
        return new JsonResult("1");
    }

    @ApiOperation("删除肥料信息")
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")Integer id){
        service.delete(id);
        return "删除成功";
    }

    @ApiOperation("添加肥料信息")
    @PostMapping("/insert")
    @ResponseBody
    public String add(@RequestBody Fertilizers fer){
        System.out.println(fer);
        service.insert(fer);
        return "添加OK";
    }
    //Put请求
    @ApiOperation("修改肥料信息")
    @PutMapping("/update")
    @ResponseBody
    public String update(@RequestBody Fertilizers fer){
        service.update(fer);
        return "修改成功";
    }

}


