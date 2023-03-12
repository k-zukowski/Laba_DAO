package org.solvd.airportservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
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
}
