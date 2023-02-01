package org.solvd.airportservice.utils.sql;

import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.solvd.airportservice.utils.Creds;

public class SQLQueries<T> {

  public Optional<T> getById(long id, String tableName, Creds creds, Class<T> entity) {
    T object = createObject(entity);

    Field[] declaredFields = entity.getDeclaredFields();
    ArrayList<String> sqlColumns = new ArrayList<>();
    StringBuilder sqlBuilder = new StringBuilder("SELECT ");
    for (Field field : declaredFields) {
      sqlColumns.add(field.getName());
      sqlBuilder.append(", ").append(field.getName());
    }
    String sql = sqlBuilder.append(" FROM ").append(tableName).append(" WHERE id = ?").toString();

    try (PreparedStatement ps = DriverManager.getConnection(creds.getUrl(), creds.getUser(),
        creds.getPassword()).prepareStatement(sql)) {
      ps.setInt(1, (int) id);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Field[] fields = entity.getDeclaredFields();
        for (Field field : fields) {
          for (String sqlField : sqlColumns) {
            if (sqlField.equals(field.getName())) {
              Field f = entity.getDeclaredField(field.getName());
              f.setAccessible(true);
              int i = List.of(sqlColumns).indexOf(field.getName());
              if (field.getType() == String.class) {
                f.set(object, rs.getString(i));
              } else if (field.getType() == int.class) {
                f.set(object, rs.getInt(i));
              } else if (field.getType() == long.class) {
                f.set(object, rs.getLong(i));
              } else if (field.getType() == Timestamp.class) {
                f.set(object, rs.getTimestamp(i));
              }
            }
          }
        }
      }
      rs.close();
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
    assert object != null;
    return Optional.of(object);
  }

  private <K> K createObject(Class<K> clazz) {
    try {
      return clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<T> getAll(String tableName, Creds creds, Class<T> entity) {

    List<T> list = new ArrayList<>();

    Field[] declaredFields = entity.getDeclaredFields();
    ArrayList<String> sqlColumns = new ArrayList<>();
    StringBuilder sqlBuilder = new StringBuilder("SELECT ");
    for (Field field : declaredFields) {
      sqlColumns.add(field.getName());
      sqlBuilder.append(", ").append(field.getName());
    }
    String sql = sqlBuilder.append(" FROM ").append(tableName).toString();

    try (PreparedStatement ps = DriverManager.getConnection(creds.getUrl(), creds.getUser(),
        creds.getPassword()).prepareStatement(sql)) {
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Field[] fields = entity.getDeclaredFields();
        T object = createObject(entity);
        for (Field field : fields) {
          for (String sqlField : sqlColumns) {
            if (sqlField.equals(field.getName())) {
              Field f = entity.getDeclaredField(field.getName());
              f.setAccessible(true);
              int i = List.of(sqlColumns).indexOf(field.getName());
              if (field.getType() == String.class) {
                f.set(object, rs.getString(i));
              } else if (field.getType() == int.class) {
                f.set(object, rs.getInt(i));
              } else if (field.getType() == long.class) {
                f.set(object, rs.getLong(i));
              } else if (field.getType() == Timestamp.class) {
                f.set(object, rs.getTimestamp(i));
              }
            }
          }
        }
        list.add(object);
      }
      rs.close();
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }


    public T update(T entitySuper, String tableName, Creds creds, Class<T> entity){

      Field[] declaredFields = entity.getDeclaredFields();
      ArrayList<String> sqlColumns = new ArrayList<>();
      StringBuilder sqlBuilder = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
      for (int i = 0; i < declaredFields.length; i++) {
        Field field = declaredFields[i];
        if (!field.getName().equals("id")) {
          sqlColumns.add(field.getName());
          if (i != declaredFields.length-1) {
            sqlBuilder.append(" = ?, ");
          }
          sqlBuilder.append(field.getName());
        }
      }
      String sql = sqlBuilder.append(" WHERE id = ?").toString();

      try (PreparedStatement ps = DriverManager.getConnection(creds.getUrl(), creds.getUser(),
          creds.getPassword()).prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();

          Field[] fields = entity.getDeclaredFields();
          for (Field field : fields) {
            for (String sqlField : sqlColumns) {

              if (sqlField.equals(field.getName())) {

                Field f = entitySuper.getClass().getDeclaredField(field.getName());
                f.setAccessible(true);
                int i = List.of(sqlColumns).indexOf(field.getName())+1;

                if (field.getType() == String.class) {
                  String val = (String) f.get(entitySuper);
                  ps.setString(i,val);
                } else if (field.getType() == int.class) {
                  int val = (int) f.get(entitySuper);
                  ps.setInt(i,val);
                } else if (field.getType() == long.class) {
                  long val = (long) f.get(entitySuper);
                  ps.setLong(i,val);
                }  else if (field.getType() == Timestamp.class) {
                  Timestamp val = (Timestamp) f.get(entitySuper);
                  ps.setTimestamp(i,val);
                }
              }
            }
          }
        ps.executeUpdate();
        rs.close();
      } catch (NoSuchFieldException | IllegalAccessException e) {
        throw new RuntimeException(e);
      } catch (SQLException e) {
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
      } catch (Exception e) {
        e.printStackTrace();
      }
      return entitySuper;
    }

    public T add(T entitySuper, String tableName, Creds creds, Class<T> entity) {

      Field[] declaredFields = entity.getDeclaredFields();
      ArrayList<String> sqlColumns = new ArrayList<>();
      StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ").append(tableName).append("(");
      for (int i = 0; i < declaredFields.length; i++) {
        Field field = declaredFields[i];
        if (!field.getName().equals("id")) {
          sqlColumns.add(field.getName());
          if (i != declaredFields.length-1) {
            sqlBuilder.append(", ");
          }
          sqlBuilder.append(field.getName());
        }
      }
      sqlBuilder.append(") VALUES (");
      for (int i = 1; i <= sqlColumns.size(); i++) {
        if (i != sqlColumns.size() - 1){
          sqlBuilder.append("?, ");
        }else {
          sqlBuilder.append("?)");
        }
      }
      String sql = sqlBuilder.toString();

      try (PreparedStatement ps = DriverManager.getConnection(creds.getUrl(), creds.getUser(),
          creds.getPassword()).prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();

        Field[] fields = entity.getDeclaredFields();
        for (Field field : fields) {
          for (String sqlField : sqlColumns) {

            if (sqlField.equals(field.getName())) {

              Field f = entitySuper.getClass().getDeclaredField(field.getName());
              f.setAccessible(true);
              int i = List.of(sqlColumns).indexOf(field.getName())+1;

              if (field.getType() == String.class) {
                String val = (String) f.get(entitySuper);
                ps.setString(i,val);
              } else if (field.getType() == int.class) {
                int val = (int) f.get(entitySuper);
                ps.setInt(i,val);
              } else if (field.getType() == long.class) {
                long val = (long) f.get(entitySuper);
                ps.setLong(i,val);
              }  else if (field.getType() == Timestamp.class) {
                Timestamp val = (Timestamp) f.get(entitySuper);
                ps.setTimestamp(i,val);
              }
            }
          }
        }
        ps.executeUpdate();
        rs.close();
      } catch (NoSuchFieldException | IllegalAccessException e) {
        throw new RuntimeException(e);
      } catch (SQLException e) {
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
      } catch (Exception e) {
        e.printStackTrace();
      }
      return entitySuper;
    }

  public boolean deleteById(String tableName, long id, Creds creds) {
    try (PreparedStatement ps = DriverManager.getConnection(creds.getUrl(), creds.getUser(),
        creds.getPassword()).prepareStatement("DELETE FROM " + tableName + " WHERE id = ?")) {
      ps.setLong(1, id);
      ps.executeUpdate();
      return true;
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}


