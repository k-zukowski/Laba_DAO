package org.solvd.airportservice.dao.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.dao.IAirlineDAO;
import org.solvd.airportservice.models.Airline;
import org.solvd.airportservice.utils.Creds;
import org.solvd.airportservice.utils.sql.SQLQueries;

public class AirlineDAO extends MySQLDAO implements IAirlineDAO {

  SQLQueries<Airline> sqlQueries = new SQLQueries<>();
  Creds creds = new Creds();
  String tableName = "Airlines";


  @Override
  public Optional<Airline> getById(long id) {
    return sqlQueries.getById(id, tableName, creds, Airline.class);
  }

  @Override
  public List<Airline> getAll() {
    return sqlQueries.getAll(tableName, creds, Airline.class);
  }

  @Override
  public Airline update(Airline entity) {
    return sqlQueries.update(entity,tableName,creds, Airline.class);
  }

  @Override
  public Airline add(Airline entity) {
    return sqlQueries.add(entity, tableName, creds, Airline.class);
  }

  @Override
  public boolean deleteById(long id) {
    return sqlQueries.deleteById(tableName, id, creds);
  }
}
