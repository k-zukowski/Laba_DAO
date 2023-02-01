package org.solvd.airportservice.dao;

import java.util.List;
import java.util.Optional;

public interface IBaseDAO<T> {

  Optional<T> getById(long id);

  List<T> getAll();

  T update(T entity);

  T add(T entity);

  boolean deleteById(long id);

}
