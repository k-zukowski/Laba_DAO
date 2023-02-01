package org.solvd.airportservice.dao;

import java.util.List;
import org.solvd.airportservice.models.Location;

public interface ILocationDAO extends IBaseDAO<Location> {

  List<Location> getAllLocations();

  Location getLocationById(long id);
}
