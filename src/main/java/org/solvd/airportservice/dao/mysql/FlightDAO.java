package org.solvd.airportservice.dao.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.dao.IFlightDAO;
import org.solvd.airportservice.models.Flight;
import org.solvd.airportservice.utils.Creds;
import org.solvd.airportservice.utils.sql.SQLQueries;

public class FlightDAO extends MySQLDAO implements IFlightDAO {

  SQLQueries<Flight> sqlQueries = new SQLQueries<>();
  Creds creds = new Creds();
  String tableName = "Flights";


  @Override
  public Optional<Flight> getById(long id) {
    return sqlQueries.getById(id, tableName, creds, Flight.class);
  }

  @Override
  public List<Flight> getAll() {
    return sqlQueries.getAll(tableName, creds, Flight.class);
  }

  @Override
  public Flight update(Flight entity) {
    return sqlQueries.update(entity,tableName,creds, Flight.class);
  }

  @Override
  public Flight add(Flight entity) {
    return sqlQueries.add(entity, tableName, creds, Flight.class);
  }

  @Override
  public boolean deleteById(long id) {
    return sqlQueries.deleteById(tableName, id, creds);
  }
}