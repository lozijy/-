package com.example.demo.controller;


import com.example.demo.domain.JsonResult;
import com.example.demo.pojo.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin //解决跨域
public class UserInfoController {

    //初始化jdbc
    @Autowired
    private JdbcTemplate jdbc;
    @ApiOperation("登录")
    //登录
    @PostMapping("/user/login")
    public JsonResult<User> login(@RequestBody User user){
        System.out.println(user);
        JsonResult<User> jsonResult=new JsonResult<>();

        try {
            User user1 = jdbc.queryForObject("select * from user where username=? and password=?",
                    new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
            log.info("登录成功");
            jsonResult.setCode("200");
            jsonResult.setData(user1);
            jsonResult.setMsg("登录成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("登录失败",e);
            jsonResult.setCode("201");
            jsonResult.setMsg("登录失败" + e.getMessage());
        }
        return jsonResult;
    }

    @ApiOperation("注册")
    //注册
    @PostMapping("/user/regist")
    public JsonResult<String> regist(@RequestBody User user){
        System.out.println(user);
        JsonResult<String> jsonResult=new JsonResult<>();
        //确认密码一致性
        if(!user.getPassword().equals(user.getConfirmPassword())){
            log.warn("注册失败:两次密码输入不一致");
            jsonResult.setCode("202");
            jsonResult.setMsg("两次密码输入不一致");
            return jsonResult;
        }

        //检查用户名是否唯一
        try {
            Integer usernameCount = jdbc.queryForObject("select count(*) from user where username = ?",
                    Integer.class, user.getUsername());
            if(usernameCount>0){
                log.warn("注册失败：用户名已经被使用");
                jsonResult.setCode("204");
                jsonResult.setMsg("用户名已经被使用");
                return jsonResult;
            }


            //如果用户名是唯一的，插入新用户记录
            int update = jdbc.update("insert into user(username,name,password,confirmPassword,mibao, mibaoanswer) values(?,?,?,?,?,?)",
                    user.getUsername(), user.getName(), user.getPassword(), user.getConfirmPassword(), user.getMibao(), user.getMibaoanswer());

            if(update>0){
                log.info("注册成功：影响行数 {}",update);
                jsonResult.setCode("200");
                jsonResult.setMsg("注册成功");
            }else {
                log.warn("注册失败：数据库未受影响");
                jsonResult.setCode("404");
                jsonResult.setMsg("注册失败");
            }
        } catch (DataAccessException e) {
            log.error("注册时发生错误",e);
            jsonResult.setCode("201");
            jsonResult.setMsg("注册失败："+e.getMessage());
        }
        return jsonResult;
    }

    @ApiOperation("确认用户名")
    //忘记密码
    @PostMapping("/user/getSecurityQuestion")
    public JsonResult<User> getSecurityQuestion(@RequestBody User user){
        JsonResult<User> jsonResult=new JsonResult<>();

        try {
            User user1 = jdbc.queryForObject("select * from user where username=?",new BeanPropertyRowMapper<>(User.class)
            , user.getUsername());
            log.info("用户名正确");
            jsonResult.setCode("200");
            jsonResult.setData(user1);
            jsonResult.setMsg("输入用户名正确");
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("用户名错误");
            jsonResult.setCode("201");
            jsonResult.setMsg("用户名错误"+e.getMessage());
        }

        return jsonResult;
    }

    @ApiOperation("密保确认")
    //密保确认
    @PostMapping("/user/checkMibao")
    public JsonResult<Void> checkMibao(@RequestBody User user){

        JsonResult<Void> jsonResult = new JsonResult<>();
        try {
            String username = user.getUsername();
            String mibaoanswer = user.getMibaoanswer();
            String storedAnswer  = jdbc.queryForObject("select mibaoanswer from user where username = ?  ",
                    String.class, username);

            if(storedAnswer != null && storedAnswer.equals(mibaoanswer)){
                //密保答案正确
                log.info("密保答案正确");
                jsonResult.setCode("200");
                jsonResult.setMsg("密保回答正确");
            }else {
                //密保答案错误
                log.warn("密保答案错误");
                jsonResult.setCode("201");
                jsonResult.setMsg("密保答案错误");
            }
        } catch (DataAccessException e) {
            log.error("数据库查询错误："+e.getMessage());
            jsonResult.setCode("500");
            jsonResult.setMsg("服务器错误");
        }
        return jsonResult;
    }

    @ApiOperation("修改密码")
    //修改密码
    @PostMapping("/user/updatePassword")
    public JsonResult<String> updatePassword(@RequestBody User user){
        JsonResult<String>jsonResult=new JsonResult<>();
        try {
            String username = user.getUsername();
            String password = user.getNewPassword();
            String confirmPassword = user.getConfirmPassword();
            //检查密码一致性
            if(!user.getNewPassword().equals(user.getConfirmPassword())){
                jsonResult.setCode("202");
                jsonResult.setMsg("两次密码输入不一致");
                return jsonResult;
            }
            System.out.println(username);
            System.out.println(password);
            System.out.println(confirmPassword);
            //更新密码
            int change = jdbc.update("update user set password = ? , confirmPassword = ? where username = ? ",
                    password,confirmPassword,username);
            if(change>0){
                jsonResult.setCode("200");
                jsonResult.setMsg("密码更新成功");
            }else {
                jsonResult.setCode("203");
                jsonResult.setMsg("密码更新失败");
            }
        } catch (DataAccessException e) {
            log.error("数据库操作异常：{}",e.getMessage());
            jsonResult.setCode("500");
            jsonResult.setMsg("服务器内部错误");
        }
        return jsonResult;
    }

    @ApiOperation("显示用户信息")
    //显示用户信息
    @GetMapping("/user/info")
    public JsonResult info(String username){
        System.out.println(username);
        log.info("username:{}",username);
        JsonResult jsonResult=new JsonResult();

        try {
            //执行sql
            User user = jdbc.queryForObject("select * from user where username = ?",new BeanPropertyRowMapper<>(User.class),username);
            jsonResult.setCode("200");
            jsonResult.setData(user);
            return jsonResult;
        } catch (DataAccessException e) {
            log.error("用户信息查询失败");
            jsonResult.setCode("201");
            jsonResult.setMsg("用户名不存在");
            return jsonResult;
        }
    }

    @ApiOperation("修改用户信息")
    //修改用户信息
    @PostMapping("/user/updateInfo")
    public JsonResult updateInfo(@RequestBody User user){
        System.out.println(user);
        JsonResult jsonResult=new JsonResult();

        try {
            //更新数据update
            int update=jdbc.update("update user set name = ? ,age = ? ,gender = ?  where username = ?",
                    user.getName(), user.getAge(), user.getGender(), user.getUsername());
            System.out.println("影响的行数："+update);
            jsonResult.setCode("200");
            jsonResult.setMsg("修改信息成功");
            return jsonResult;
        } catch (DataAccessException e) {
            jsonResult.setCode("201");
            jsonResult.setMsg("修改信息失败");
            return jsonResult;
        }
    }

}
