package org.solvd.airportservice.services;

import org.solvd.airportservice.dao.IAirlineDAO;
import org.solvd.airportservice.dao.mysql.AirlineDAO;

public class AirlineServiceImpl implements IArilineService {

  private final IAirlineDAO aDAO = new AirlineDAO();
  //others DAO-s

//  public Optional<Airline> getAirplaneByName(String name) {
//    return aDAO.getEntityByName(name);
//  }

}
