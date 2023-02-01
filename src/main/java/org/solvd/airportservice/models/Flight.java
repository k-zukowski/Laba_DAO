package org.solvd.airportservice.models;

import java.time.LocalDateTime;

public class Flight {

  private long id;
  private LocalDateTime departure;
  private LocalDateTime arrival;
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

  public LocalDateTime getDeparture() {
    return departure;
  }

  public void setDeparture(LocalDateTime departure) {
    this.departure = departure;
  }

  public LocalDateTime getArrival() {
    return arrival;
  }

  public void setArrival(LocalDateTime arrival) {
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
