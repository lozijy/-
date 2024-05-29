package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.TemperatureAndHumidityMapper;
import com.example.demo.pojo.Humiditysensordata;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import com.example.demo.pojo.waterData;
import com.example.demo.service.SensorService;
import com.example.demo.util.DatabaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.jsp.jstl.sql.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    int[] indexs=new int[13];
    double[] tu_hu=new double[13];
    double[] kong_hu=new double[13];
    double[] kong_wen=new double[13];
    double[] tu_wen=new double[13];
    double[] dan=new double[13];
    double[] P=new double[13];
    double[] Conductivity=new double[13];
    double[] PH=new double[13];
    private TemperatureAndHumidityMapper mapper;
    @Autowired
    public SensorServiceImpl() throws SQLException {
        this.mapper=mapper;
        initService();
    }


    private void initService() throws SQLException
        {
            System.out.println("init");
            System.out.println("111");
            indexs[0]=20652;
            for (int i = 1; i < 13; i++) {
                indexs[i] = indexs[i - 1] + 7200;
            }
            for (int i = 0; i < 13; i++) {
                Result res1 =  DatabaseUtils.getSensorData1(indexs[i]);//土壤
                Result res2 = DatabaseUtils.getSensorData2(indexs[i]);//空气
                Result res3 = DatabaseUtils.getSensorData3(indexs[i]);//水
                if(res1.getRowCount()!=0){
                    tu_wen[i]= (double)res1.getRowsByIndex()[0][4];//温度
                    tu_hu[i] = (double)res1.getRowsByIndex()[0][2];//湿度

                }
                if (res2.getRowCount()!=0) {
                    kong_wen[i]= (double)res2.getRowsByIndex()[0][2];//温度
                    kong_hu[i] = (double)res2.getRowsByIndex()[0][3];//湿度
                }
                if(res3.getRowCount()!=0){
                    dan[i] = Double.parseDouble(res3.getRowsByIndex()[0][5].toString());//湿度
                    P[i] = Double.parseDouble(res3.getRowsByIndex()[0][4].toString());//湿度
                    PH[i] = Double.parseDouble(res3.getRowsByIndex()[0][2].toString());//湿度
                    Conductivity[i] = Double.parseDouble(res3.getRowsByIndex()[0][3].toString());//湿度
                }
                }
            }




    @Override
    public List<waterData> queryWater() {
        return mapper.queryWater();
    }

    @Override
    public List<Temperatureandhumiditysensordata> queryTemper() {
        return mapper.queryTemper();
    }

    @Override
    public List<Humiditysensordata> queryHumidity() {
        return mapper.queryHumidity();
    }

    @Override
    public void insert(Temperatureandhumiditysensordata data) {
        mapper.insert(data);
    }

    @Override
    public double[] getTu_hu() {
        return tu_hu;
    }

    @Override
    public double[] getKong_hu() {
        System.out.println("ok");
        return kong_hu;
    }

    @Override
    public double[] get_Dan() {
        return dan;
    }

    @Override
    public double[] get_P() {
        return P;
    }

    @Override
    public double[] get_Conductivity() {
        return Conductivity;
    }

    @Override
    public double[] get_PH() {
        return PH;
    }

    @Override
    public double[] getTu_wen() {
            return tu_wen;

    }

    @Override
    public double[] getKong_wen() {
        return kong_wen;
    }
}
