package org.solvd.airportservice.models;

import java.sql.Timestamp;

public class Flight {

  private long id;
  private Timestamp departure;
  private Timestamp arrival;
  private String status;
  private long airplaneId;
  private long originId;
  private long destinationId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Timestamp getDeparture() {
    return departure;
  }

  public void setDeparture(Timestamp departure) {
    this.departure = departure;
  }

  public Timestamp getArrival() {
    return arrival;
  }

  public void setArrival(Timestamp arrival) {
    this.arrival = arrival;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public long getAirplaneId() {
    return airplaneId;
  }

  public void setAirplaneId(long airplaneId) {
    this.airplaneId = airplaneId;
  }

  public long getOriginId() {
    return originId;
  }

  public void setOriginId(long originId) {
    this.originId = originId;
  }

  public long getDestinationId() {
    return destinationId;
  }

  public void setDestinationId(long destinationId) {
    this.destinationId = destinationId;
  }
}
