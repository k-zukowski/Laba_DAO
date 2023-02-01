package org.solvd.airportservice.dao;

import java.util.List;
import org.solvd.airportservice.models.Airplane;

public interface IAirplaneDAO extends IBaseDAO<Airplane> {

  List<Airplane> getAllAirplanes();

  Airplane getAirplaneById(long id);
}
