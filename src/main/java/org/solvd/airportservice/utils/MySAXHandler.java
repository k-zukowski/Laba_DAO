package org.solvd.airportservice.utils;

import java.util.ArrayList;
import java.util.List;
import org.solvd.airportservice.models.Location;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXHandler extends DefaultHandler {

  boolean bId = false;
  boolean bAirportName = false;
  private List<Location> locList = null;
  private Location loc = null;
  private StringBuilder data = null;

  public List<Location> getLocList() {
    return locList;
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {

    if (qName.equalsIgnoreCase("Location")) {
      // create a new locloyee and put it in Map
      String id = attributes.getValue("id");
      // initialize locloyee object and set id attribute
      loc = new Location();
      loc.setId(Integer.parseInt(id));
      // initialize list
      if (locList == null) {
        locList = new ArrayList<>();
      }
    } else if (qName.equalsIgnoreCase("id")) {
      // set boolean values for fields, will be used in setting locloyee variables
      bId = true;
    } else if (qName.equalsIgnoreCase("airportName")) {
      bAirportName = true;
    }
    // create the data container
    data = new StringBuilder();
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (bId) {
      // age element, set Employee age
      loc.setId(Integer.parseInt(data.toString()));
      bId = false;
    } else if (bAirportName) {
      loc.setAirportName(data.toString());
      bAirportName = false;
    }

    if (qName.equalsIgnoreCase("Location")) {

      locList.add(loc);
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    data.append(new String(ch, start, length));
  }

}
