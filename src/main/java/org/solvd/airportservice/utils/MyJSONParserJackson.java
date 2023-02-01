package org.solvd.airportservice.utils;

import static org.solvd.airportservice.commons_shared.Const.LOCATIONS_JSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.solvd.airportservice.models.Location;


public class MyJSONParserJackson {

  public void parse() {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      File jsonFile = new File(LOCATIONS_JSON);
      LocationsJackson locations = objectMapper.readValue(jsonFile, LocationsJackson.class);

      for (Location location : locations.getLocations().getLocation()) {
        System.out.println("id: " + location.getId());
        System.out.println("airportName: " + location.getAirportName());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class LocationsJackson {

  @JsonProperty("Locations")
  private LocationList locationList;

  public LocationList getLocations() {
    return locationList;
  }

  public void setLocations(LocationList locationList) {
    this.locationList = locationList;
  }
}

class LocationList {

  @JsonProperty("Location")
  private List<Location> location;

  public List<Location> getLocation() {
    return location;
  }

  public void setLocation(List<Location> location) {
    this.location = location;
  }
}
