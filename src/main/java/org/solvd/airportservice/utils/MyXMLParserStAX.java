package org.solvd.airportservice.utils;

import static org.solvd.airportservice.commons_shared.Const.LOCATIONS_XML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;


public class MyXMLParserStAX {

  public void parse(){
    try {
      Path path = Paths.get(LOCATIONS_XML);
      XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

      // https://rules.sonarsource.com/java/RSPEC-2755
      // prevent xxe
      xmlInputFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
      xmlInputFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

      XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(
          new FileInputStream(path.toFile()));

      int eventType = reader.getEventType();
      //System.out.println(eventType);   // 7, START_DOCUMENT
      //System.out.println(reader);      // xerces

      while (reader.hasNext()) {

        eventType = reader.next();

        if (eventType == XMLEvent.START_ELEMENT) {

          switch (reader.getName().getLocalPart()) {
            case "Location" -> {
              String id = reader.getAttributeValue(null, "id");
              System.out.printf("Location id : %s%n", id);
            }
            case "airportName" -> {
              eventType = reader.next();
              if (eventType == XMLEvent.CHARACTERS) {
                System.out.printf("airportName : %s%n", reader.getText());
              }
            }
          }
        }
      }
    } catch (XMLStreamException | FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

}
