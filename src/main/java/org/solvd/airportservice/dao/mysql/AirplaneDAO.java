package org.solvd.airportservice.dao.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.dao.IAirplaneDAO;
import org.solvd.airportservice.models.Airplane;
import org.solvd.airportservice.utils.Creds;
import org.solvd.airportservice.utils.sql.SQLQueries;

public class AirplaneDAO extends MySQLDAO implements IAirplaneDAO {

  SQLQueries<Airplane> sqlQueries = new SQLQueries<>();
  Creds creds = new Creds();
  String tableName = "Airplanes";


  @Override
  public Optional<Airplane> getById(long id) {
    return sqlQueries.getById(id, tableName, creds, Airplane.class);
  }

  @Override
  public List<Airplane> getAll() {
    return sqlQueries.getAll(tableName, creds, Airplane.class);
  }

  @Override
  public Airplane update(Airplane entity) {
    return sqlQueries.update(entity,tableName,creds, Airplane.class);
  }

  @Override
  public Airplane add(Airplane entity) {
    return sqlQueries.add(entity, tableName, creds, Airplane.class);
  }

  @Override
  public boolean deleteById(long id) {
    return sqlQueries.deleteById(tableName, id, creds);
  }
}