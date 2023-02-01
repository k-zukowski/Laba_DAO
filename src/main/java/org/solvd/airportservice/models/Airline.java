package org.solvd.airportservice.models;

public class Airline {

  private String name;
  private String headquarters;
  private int fleetSize;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHeadquarters() {
    return headquarters;
  }

  public void setHeadquarters(String headquarters) {
    this.headquarters = headquarters;
  }

  public int getFleetSize() {
    return fleetSize;
  }

  public void setFleetSize(int fleetSize) {
    this.fleetSize = fleetSize;
  }
}
