package org.solvd.airportservice.dao;

import java.util.List;
import org.solvd.airportservice.models.Flight;

public interface IFlightDAO extends IBaseDAO<Flight> {

  List<Flight> getAllFlights();

  Flight getFlightById(long id);
}
