package org.solvd.airportservice.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;
import org.solvd.airportservice.models.Location;

public class MyXMLParserJXAB {

  private static final String FILENAME = "src/main/resources/locations.xml";

  public void parse() {
    try {
      File file = new File(FILENAME);
      JAXBContext jaxbContext = JAXBContext.newInstance(Locations.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Locations locations = (Locations) jaxbUnmarshaller.unmarshal(file);

      for (Location location : locations.getLocation()) {
        System.out.println("id: " + location.getId());
        System.out.println("airportName: " + location.getAirportName());
      }
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }
}

@XmlRootElement(name = "Locations")
@XmlAccessorType(XmlAccessType.FIELD)
class Locations {

  @XmlElement(name = "Location")
  private List<Location> location;

  public List<Location> getLocation() {
    return location;
  }

  public void setLocation(List<Location> location) {
    this.location = location;
  }
}
