package org.solvd.airportservice.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Location {

  @XmlAttribute(name = "id")
  private long id;

  @XmlElement(name = "airportName")
  private String airportName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAirportName() {
    return airportName;
  }

  public void setAirportName(String airportName) {
    this.airportName = airportName;
  }

  @Override
  public String toString() {
    return "Location{" +
        "id=" + id +
        ", airportName='" + airportName + '\'' +
        '}';
  }
}
