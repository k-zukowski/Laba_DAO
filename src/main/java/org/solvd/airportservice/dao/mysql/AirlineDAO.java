package org.solvd.airportservice.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.dao.IAirlineDAO;
import org.solvd.airportservice.models.Airline;
import org.solvd.airportservice.utils.Creds;

public class AirlineDAO extends MySQLDAO implements IAirlineDAO {

  Creds creds = new Creds();

  @Override
  public List<Airline> getAllAirlines() {
    return null;
  }

  @Override
  public Airline getAirlineByName(String name) {
    return null;
  }

  @Override
  public Optional<Airline> getEntityById(long id) {
    return Optional.empty();
  }

  @Override
  public Optional<Airline> getEntityByName(String name) {
    Connection connection;
    Airline a = new Airline();
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
          "SELECT * from AIRLINES where name = ?")) {
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          a.setName(name);
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
  public void updateEntity(Airline entity) {

  }

  @Override
  public Airline createEntity(Airline entity) {
    return null;
  }

  @Override
  public void removeEntityById(long id) {

  }
}
