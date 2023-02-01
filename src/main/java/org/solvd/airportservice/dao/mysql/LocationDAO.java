package org.solvd.airportservice.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.dao.ILocationDAO;
import org.solvd.airportservice.models.Location;
import org.solvd.airportservice.utils.Creds;

public class LocationDAO extends MySQLDAO implements ILocationDAO {

  Creds creds = new Creds();

  @Override
  public Optional<Location> getEntityById(long id) {
    Connection connection;
    Location l = new Location();
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
          "SELECT * from Locations where id = ?")) {
        ps.setInt(1, Math.toIntExact(id));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          l.setId(id);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.of(l);
  }

  @Override
  public Optional<Location> getEntityByName(String name) {
    return Optional.empty();
  }

  @Override
  public void updateEntity(Location entity) {

  }

  @Override
  public Location createEntity(Location entity) {
    return null;
  }

  @Override
  public void removeEntityById(long id) {

  }

  @Override
  public List<Location> getAllLocations() {
    return null;
  }

  @Override
  public Location getLocationById(long id) {
    return null;
  }
}
