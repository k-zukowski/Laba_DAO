package org.solvd.airportservice.models;

public class Airline {

  private long id;
  private String name;
  private String headquarters;
  private int fleetSize;

  public Airline(long id, String name, String headquarters, int fleetSize) {
    this.id = id;
    this.name = name;
    this.headquarters = headquarters;
    this.fleetSize = fleetSize;
  }

  public Airline(String name, String headquarters, int fleetSize) {
    this.name = name;
    this.headquarters = headquarters;
    this.fleetSize = fleetSize;
  }

  public Airline() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

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

  @Override
  public String toString() {
    return "Airline{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", headquarters='" + headquarters + '\'' +
        ", fleetSize=" + fleetSize +
        '}';
  }
}
