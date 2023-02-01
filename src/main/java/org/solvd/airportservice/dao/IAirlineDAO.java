package org.solvd.airportservice.dao;

import java.util.List;
import org.solvd.airportservice.models.Airline;

public interface IAirlineDAO extends IBaseDAO<Airline> {

  List<Airline> getAllAirlines();

  Airline getAirlineByName(String name);
}
