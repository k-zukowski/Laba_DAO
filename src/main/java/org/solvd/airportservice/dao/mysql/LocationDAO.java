package org.solvd.airportservice.dao.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.dao.ILocationDAO;
import org.solvd.airportservice.models.Location;
import org.solvd.airportservice.models.Location;
import org.solvd.airportservice.utils.Creds;
import org.solvd.airportservice.utils.sql.SQLQueries;

public class LocationDAO extends MySQLDAO implements ILocationDAO {

  SQLQueries<Location> sqlQueries = new SQLQueries<>();
  Creds creds = new Creds();
  String tableName = "Locations";


  @Override
  public Optional<Location> getById(long id) {
    return sqlQueries.getById(id, tableName, creds, Location.class);
  }

  @Override
  public List<Location> getAll() {
    return sqlQueries.getAll(tableName, creds, Location.class);
  }

  @Override
  public Location update(Location entity) {
    return sqlQueries.update(entity,tableName,creds, Location.class);
  }

  @Override
  public Location add(Location entity) {
    return sqlQueries.add(entity, tableName, creds, Location.class);
  }

  @Override
  public boolean deleteById(long id) {
    return sqlQueries.deleteById(tableName, id, creds);
  }
}