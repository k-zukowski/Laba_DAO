package org.solvd.airportservice.services;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.solvd.airportservice.dao.IAirlineDAO;
import org.solvd.airportservice.dao.mysql.AirlineDAO;
import org.solvd.airportservice.models.Airline;
import org.solvd.airportservice.models.Airplane;
import org.solvd.airportservice.models.Flight;
import org.solvd.airportservice.models.Staff;

public class AirlineServiceImpl implements IAirlineService {
  SqlSessionFactory sqlSessionFactory;

  public AirlineServiceImpl() {
    try {
      Reader reader = Resources.getResourceAsReader("myBatis-config.xml");
      this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Airline getAirline(int id) {
    Airline airline;
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      airline = iAirlineDAO.getAirline(id);
    }
    return airline;
  }

  @Override
  public Airline getAirline(String name) {
    Airline airline;
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      airline = iAirlineDAO.getAirline(name);
    }
    return airline;
  }

  @Override
  public Airline getAirLine(Airplane airplane) {
    Airline airline;
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      airline = iAirlineDAO.getAirLine(airplane);
    }
    return airline;
  }

  @Override
  public List<Airline> getAllAirlines() {
    List<Airline> airlines;
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      airlines = iAirlineDAO.getAllAirlines();
    }
    return airlines;
  }

  @Override
  public void updateAirline(int id, Airline airline) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      try {
        iAirlineDAO.updateAirline(id, airline);
        sqlSession.commit();
      } catch (Exception e) {
        sqlSession.rollback();
      }
    }
  }

  @Override
  public void updateAirline(Airline airline) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      try {
        iAirlineDAO.updateAirline(airline);
        sqlSession.commit();
      } catch (Exception e) {
        sqlSession.rollback();
      }
    }
  }

  @Override
  public void deleteAirline(int id) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      try {
        iAirlineDAO.deleteAirline(id);
        sqlSession.commit();
      } catch (Exception e) {
        sqlSession.rollback();
      }
    }
  }

  @Override
  public void addAirline(Airline airline) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      try {
        iAirlineDAO.addAirline(airline);
        sqlSession.commit();
      } catch (Exception e) {
        sqlSession.rollback();
      }
    }
  }

/*  @Override
  public Airline addAirline(Airline airline, List<Airplane> airplanes, List<Staff> staff) {
    return null;
  }*/

  @Override
  public void removeAirplane(int airplaneId) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      try {
        iAirlineDAO.removeAirplane(airplaneId);
        sqlSession.commit();
      } catch (Exception e) {
        sqlSession.rollback();
      }
    }
  }

  @Override
  public void addAirplane(int airplaneId) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      try {
        iAirlineDAO.addAirplane(airplaneId);
        sqlSession.commit();
      } catch (Exception e) {
        sqlSession.rollback();
      }
    }
  }

  @Override
  public void maintainAirplane(int airplaneId) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      try {
        iAirlineDAO.maintainAirplane(airplaneId);
        sqlSession.commit();
      } catch (Exception e) {
        sqlSession.rollback();
      }
    }
  }

  @Override
  public void scheduleFlight() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO iAirlineDAO = sqlSession.getMapper(IAirlineDAO.class);
      try {
        iAirlineDAO.scheduleFlight();
        sqlSession.commit();
      } catch (Exception e) {
        sqlSession.rollback();
      }
    }
  }

  @Override
  public Flight getFlightInformation(int flightId) {
    Flight flight;
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      IAirlineDAO transitPointDAO = sqlSession.getMapper(IAirlineDAO.class);
      flight = transitPointDAO.getFlightInformation(flightId);
    }
    return flight;
  }
}
