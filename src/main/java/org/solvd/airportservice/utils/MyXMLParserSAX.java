package org.solvd.airportservice.utils;

import static org.solvd.airportservice.commons_shared.Const.LOCATIONS_XML;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.solvd.airportservice.models.Location;
import org.xml.sax.SAXException;


public class MyXMLParserSAX {

  public void parse() {
    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
      SAXParser saxParser = saxParserFactory.newSAXParser();
      MySAXHandler handler = new MySAXHandler();
      saxParser.parse(new File(LOCATIONS_XML), handler);
      List<Location> locList = handler.getLocList();
      for (Location loc : locList) {
        System.out.println(loc);
      }
    } catch (ParserConfigurationException | SAXException | IOException e) {
      e.printStackTrace();
    }
  }
}
//C:\Users\kzuko\OneDrive\Desktop\Laba_DAO\src\main\resources\mysqlcreds.properties