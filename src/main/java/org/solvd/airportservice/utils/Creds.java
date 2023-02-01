package org.solvd.airportservice.utils;

import static org.solvd.airportservice.commons_shared.Const.MYSQL_CREDS_PROPERTIES;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Creds {

  private final String url;
  private final String user;
  private final String password;

  public Creds() {
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream(MYSQL_CREDS_PROPERTIES));
      this.url = properties.getProperty("url");
      this.user = properties.getProperty("user");
      this.password = properties.getProperty("password");

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String getUrl() {
    return url;
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }
}
