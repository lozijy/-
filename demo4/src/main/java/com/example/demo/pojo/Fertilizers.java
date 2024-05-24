package com.example.demo.pojo;


public class Fertilizers {

  private long id;
  private java.sql.Date fertilizationDate;
  private String fertilizerType;
  private double fertilizerAmount;
  private java.sql.Date nextFertilizationDate;
  private String memo;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }




  public java.sql.Date getFertilizationDate() {
    return fertilizationDate;
  }

  public void setFertilizationDate(java.sql.Date fertilizationDate) {
    this.fertilizationDate = fertilizationDate;
  }


  public String getFertilizerType() {
    return fertilizerType;
  }

  public void setFertilizerType(String fertilizerType) {
    this.fertilizerType = fertilizerType;
  }


  public double getFertilizerAmount() {
    return fertilizerAmount;
  }

  public void setFertilizerAmount(double fertilizerAmount) {
    this.fertilizerAmount = fertilizerAmount;
  }


  public java.sql.Date getNextFertilizationDate() {
    return nextFertilizationDate;
  }

  public void setNextFertilizationDate(java.sql.Date nextFertilizationDate) {
    this.nextFertilizationDate = nextFertilizationDate;
  }


  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

}
