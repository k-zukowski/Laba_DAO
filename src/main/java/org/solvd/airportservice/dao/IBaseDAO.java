package org.solvd.airportservice.dao;

import java.util.Optional;

public interface IBaseDAO<T> {

  Optional<T> getEntityById(long id);

  Optional<T> getEntityByName(String name);

  void updateEntity(T entity);

  T createEntity(T entity);

  void removeEntityById(long id);

}
