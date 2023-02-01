package org.solvd.airportservice.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.dao.IAirplaneDAO;
import org.solvd.airportservice.models.Airplane;
import org.solvd.airportservice.utils.Creds;

public class AirplaneDAO extends MySQLDAO implements IAirplaneDAO {

  Creds creds = new Creds();

  @Override
  public List<Airplane> getAllAirplanes() {
    return null;
  }

  @Override
  public Airplane getAirplaneById(long id) {
    return null;
  }

  @Override
  public Optional<Airplane> getEntityById(long id) {

    Connection connection;
    Airplane a = new Airplane();
    try {
      connection = DriverManager.getConnection(creds.getUrl(), creds.getUser(),
          creds.getPassword());
      if (connection != null) {
        System.out.println("Successfully connected.");
      } else {
        System.out.println("Failed to connect.");
      }
      assert connection != null;
      try (PreparedStatement ps = connection.prepareStatement(
          "SELECT * from AIRPLANES where id = ?")) {
        ps.setInt(1, Math.toIntExact(id));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          a.setId(id);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.of(a);
  }

  @Override
  public Optional<Airplane> getEntityByName(String name) {
    return Optional.empty();
  }

  @Override
  public void updateEntity(Airplane entity) {

  }

  @Override
  public Airplane createEntity(Airplane entity) {
    return null;
  }

  @Override
  public void removeEntityById(long id) {

  }
}
