package org.solvd.airportservice;

import org.solvd.airportservice.services.AirlineService;
import org.solvd.airportservice.utils.MyJSONParserJackson;
import org.solvd.airportservice.utils.MyXMLParserDOM;
import org.solvd.airportservice.utils.MyXMLParserJXAB;
import org.solvd.airportservice.utils.MyXMLParserSAX;
import org.solvd.airportservice.utils.MyXMLParserStAX;

public class Main {

  public static void main(String[] args) {
    AirlineService as = new AirlineService();

    MyXMLParserSAX myXMLParserSAX = new MyXMLParserSAX();
    myXMLParserSAX.parse();

    MyXMLParserStAX myXMLParserStAX = new MyXMLParserStAX();
    myXMLParserStAX.parse();

    MyXMLParserDOM myXMLParserDOM = new MyXMLParserDOM();
    myXMLParserDOM.parse();

    MyXMLParserJXAB myXMLParserJXAB = new MyXMLParserJXAB();
    myXMLParserJXAB.parse();

    MyJSONParserJackson myJSONParserJackson = new MyJSONParserJackson();
    myJSONParserJackson.parse();

  }
}