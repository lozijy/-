package com.example.demo.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/23:37
 * @Description:
 */

public class waterData{
    private final String type="water";
    private java.sql.Date timestamp;
    double phValue;
    double conductivity;
    double totalPhosphorus;
    double totalNitrogen;


    public String getType(){return this.type;}
    public double getPhValue(){
        return phValue;
    }
    public double getConductivity(){
        return conductivity;

    }
    public double getTotalPhosphorus(){
        return totalPhosphorus;
    }
    public double getTotalNitrogen(){
        return this.totalNitrogen;
    }
    public java.sql.Date getTimestamp(){
        return this.timestamp;
    }

    public waterData(java.sql.Date timestamp, double phValue, double conductivity, double totalPhosphorus, double totalNitrogen){
        this.conductivity=conductivity;
        this.timestamp=timestamp;
        this.phValue=phValue;
        this.totalNitrogen=totalNitrogen;
        this.totalPhosphorus=totalPhosphorus;
    }


}