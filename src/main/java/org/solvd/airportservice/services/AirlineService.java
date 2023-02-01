package org.solvd.airportservice.services;

import java.util.Optional;
import org.solvd.airportservice.dao.IAirlineDAO;
import org.solvd.airportservice.dao.mysql.AirlineDAO;
import org.solvd.airportservice.models.Airline;

public class AirlineService {

  private final IAirlineDAO aDAO = new AirlineDAO();
  //others DAO-s

  public Optional<Airline> getAirplaneByName(String name) {
    return aDAO.getEntityByName(name);
  }

}
