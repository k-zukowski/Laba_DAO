package org.solvd.airportservice.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.dao.IFlightDAO;
import org.solvd.airportservice.models.Flight;
import org.solvd.airportservice.utils.Creds;

public class FlightDAO extends MySQLDAO implements IFlightDAO {

  Creds creds = new Creds();

  @Override
  public Optional<Flight> getEntityById(long id) {
    Connection connection;
    Flight f = new Flight();
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
          "SELECT * from Flights where id = ?")) {
        ps.setInt(1, Math.toIntExact(id));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          f.setId(id);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.of(f);
  }

  @Override
  public Optional<Flight> getEntityByName(String name) {
    return Optional.empty();
  }

  @Override
  public void updateEntity(Flight entity) {

  }

  @Override
  public Flight createEntity(Flight entity) {
    return null;
  }

  @Override
  public void removeEntityById(long id) {

  }

  @Override
  public List<Flight> getAllFlights() {
    return null;
  }

  @Override
  public Flight getFlightById(long id) {
    return null;
  }
}
