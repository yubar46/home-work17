package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public interface BaseRepository<T, ID> {
  void create(T t);

  T find(ID id);

  T update(T t);

  void delete(ID id);

  List<T> findAll(T t);

  void beginTransaction();

  void commitTransaction();

  void rollbackTransaction();

  EntityTransaction getTransaction();

  EntityManager getEntityManager();

}
