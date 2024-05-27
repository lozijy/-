package com.example.demo.pojo;


public class Humiditysensordata {

  private final String type="turang";
  private long id;
  private long sensorId;
  private double humidity;
  private double temperature;
  private java.sql.Date timestamp;

  public double getTemperature() {
    return temperature;
  }
  public void setTemperature(double temperature){
    this.temperature=temperature;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getType(){return this.type;}

  public long getSensorId() {
    return sensorId;
  }

  public void setSensorId(long sensorId) {
    this.sensorId = sensorId;
  }


  public double getHumidity() {
    return humidity;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }


  public java.sql.Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(java.sql.Date timestamp) {
    this.timestamp = timestamp;
  }
  public Humiditysensordata(int sensorId, double humidity,double temperature ,java.sql.Date timestamp) {
    this.sensorId=sensorId;
    this.humidity=humidity;
    this.timestamp=timestamp;
    this.temperature=temperature;
  }
  public Humiditysensordata(int id,int sensorId, double humidity,java.sql.Date timestamp ,double temperature ) {
    this.id=id;
    this.sensorId=sensorId;
    this.humidity=humidity;
    this.timestamp=timestamp;
    this.temperature=temperature;
  }
}
