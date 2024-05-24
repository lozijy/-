package com.example.demo.pojo;


import java.sql.Date;

public class Temperatureandhumiditysensordata {
  private final String type="kongqi";

  private long id;
  private long sensorId;
  private double temperature;
  private double humidity;
  private java.sql.Date timestamp;



  public Temperatureandhumiditysensordata(int sensorId, double temperature, double humidity, Date timestamp) {
    this.sensorId=sensorId;
    this.temperature=temperature;
    this.humidity=humidity;
    this.timestamp=timestamp;
  }

  public String getType(){return this.type;}
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSensorId() {
    return sensorId;
  }

  public void setSensorId(long sensorId) {
    this.sensorId = sensorId;
  }


  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
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

}
