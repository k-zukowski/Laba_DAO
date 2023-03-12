package org.solvd.airportservice.services;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.solvd.airportservice.models.Airline;
import org.solvd.airportservice.models.Airplane;
import org.solvd.airportservice.models.Flight;
import org.solvd.airportservice.models.Staff;

public interface IAirlineService {

  Airline getAirline(int id);
  Airline getAirline(String name);
  Airline getAirLine(Airplane airplane);
  List<Airline> getAllAirlines();
  void updateAirline(@Param("id")int id, @Param("airline")Airline airline);
  void updateAirline(Airline airline);
  void deleteAirline(int id);
  void addAirline(Airline airline);
  //void addAirline(Airline airline, List<Airplane> airplanes, List<Staff> staff);
  void removeAirplane(int airplaneId);
  void addAirplane(int airplaneId);
  void maintainAirplane(int airplaneId);
  void scheduleFlight(); // all information that should be known to schedule a flight
  Flight getFlightInformation(int flightId); // return all information related a specific flight only if it is related to a certain airline company

}
