package com.example.demo.util;


import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.pojo.waterData;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;


import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/23/9:55
 * @Description:
 */
public class DatabaseUtils {
    private static final String URL = "jdbc:mysql://106.54.195.222:3306/swu4";
    private static final String USERNAME = "swu4";
    private static final String PASSWORD = "swu4";

    public static void saveSensorData(Temperatureandhumiditysensordata sensorData) {
        try {
            // 获取数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 准备 SQL 语句
            String sql = "INSERT INTO swu4.temperatureandhumiditysensordata (sensorId, temperature, Humidity, timestamp) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 设置参数值
            statement.setLong(1, sensorData.getSensorId());
            statement.setDouble(2, sensorData.getTemperature());
            statement.setDouble(3, sensorData.getHumidity());
            statement.setDate(4, sensorData.getTimestamp());

            // 执行 SQL 语句
            statement.executeUpdate();

            // 关闭资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveWaterData(waterData sensorData) {
        try {
            // 获取数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 准备 SQL 语句
            String sql = "INSERT INTO swu4.watersourcemanagement ( samplingTime, phValue, conductivity,totalPhosphorus,totalNitrogen) VALUES ( ?, ?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 设置参数值
            statement.setDate(1, sensorData.getTimestamp());
            statement.setDouble(2, sensorData.getPhValue());
            statement.setDouble(3, sensorData.getConductivity());
            statement.setDouble(4, sensorData.getTotalPhosphorus());
            statement.setDouble(5, sensorData.getTotalNitrogen());
            // 执行 SQL 语句
            statement.executeUpdate();

            // 关闭资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveSensorData(Humiditysensordata sensorData) {
        try {
            // 获取数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 准备 SQL 语句
            String sql = "INSERT INTO swu4.humiditysensordata (sensorId, temperature, humidity, timestamp) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // 设置参数值
            statement.setLong(1, sensorData.getSensorId());
            statement.setDouble(2, sensorData.getTemperature());
            statement.setDouble(3, sensorData.getHumidity());
            statement.setDate(4, sensorData.getTimestamp());

            // 执行 SQL 语句
            statement.executeUpdate();

            // 关闭资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Result getSensorData1(int id) {
        try {
            // 获取数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 准备 SQL 语句
            String sql = "SELECT * FROM swu4.humiditysensordata where id= ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);

            // 执行 SQL 语句
            ResultSet resultSet = statement.executeQuery();
            Result result= ResultSupport.toResult(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Result getSensorData2(int id) {
        try {
            // 获取数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 准备 SQL 语句
            String sql = "SELECT * FROM swu4.temperatureandhumiditysensordata where id= ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            // 执行 SQL 语句
            ResultSet resultSet = statement.executeQuery();

            Result result= ResultSupport.toResult(resultSet);

            resultSet.close();
            statement.close();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Result getSensorData3(int id) {
        try {
            // 获取数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 准备 SQL 语句
            String sql = "SELECT * FROM swu4.watersourcemanagement where id= ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            // 执行 SQL 语句
            ResultSet resultSet = statement.executeQuery();

            Result result= ResultSupport.toResult(resultSet);

            resultSet.close();
            statement.close();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
