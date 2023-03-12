package org.solvd.airportservice;

import org.solvd.airportservice.models.Airline;
import org.solvd.airportservice.utils.Creds;
import org.solvd.airportservice.utils.sql.SQLQueries;

public class Main {

  public static void main(String[] args) {
    //AirlineServiceImpl as = new AirlineServiceImpl();

/*    MyXMLParserSAX myXMLParserSAX = new MyXMLParserSAX();
    myXMLParserSAX.parse();

    MyXMLParserStAX myXMLParserStAX = new MyXMLParserStAX();
    myXMLParserStAX.parse();

    MyXMLParserDOM myXMLParserDOM = new MyXMLParserDOM();
    myXMLParserDOM.parse();

    MyXMLParserJXAB myXMLParserJXAB = new MyXMLParserJXAB();
    myXMLParserJXAB.parse();

    MyJSONParserJackson myJSONParserJackson = new MyJSONParserJackson();
    myJSONParserJackson.parse();*/

    SQLQueries<Airline> sqlQueries = new SQLQueries<>();
    Creds creds = new Creds();
    sqlQueries.getById(2L, "SELECT name, headquarters, fleet_size FROM Airlines WHERE name = ?",
        creds,
        Airline.class);


  }
}