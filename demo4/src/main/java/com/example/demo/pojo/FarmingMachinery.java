package com.example.demo.pojo;


public class FarmingMachinery {

  private long id;
  private java.sql.Date usageDate;
  private String purpose;
  private String maintenanceStatus;
  private java.sql.Date purchaseDate;
  private long ownerId;
  private String name;

  public String getName(){
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }
  public long getOwnerId(){return this.ownerId;}
  public void setOwnerId(long ownerId){this.ownerId=ownerId;}


  public java.sql.Date getUsageDate() {
    return this.usageDate;
  }

  public void setUsageDate(java.sql.Date usageDate) {
    this.usageDate = usageDate;
  }


  public String getPurpose() {
    return this.purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }


  public String getMaintenanceStatus() {
    return this.maintenanceStatus;
  }

  public void setMaintenanceStatus(String maintenanceStatus) {
    this.maintenanceStatus = maintenanceStatus;
  }


  public java.sql.Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(java.sql.Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

}
