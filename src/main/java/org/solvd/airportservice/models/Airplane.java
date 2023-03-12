package org.solvd.airportservice.models;

public class Airplane {

  private long id;
  private String manufacturer;
  private String model;
  private long airlineId;
  private long dimensionId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public long getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(long airlineId) {
    this.airlineId = airlineId;
  }

  public long getDimensionId() {
    return dimensionId;
  }

  public void setDimensionId(long dimensionId) {
    this.dimensionId = dimensionId;
  }
}
