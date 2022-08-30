package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class BaseRepositoryImpl<T, ID> implements BaseRepository<T, ID> {
  protected final EntityManager entityManager;
  protected final Class<T> entityClass;

  public BaseRepositoryImpl(EntityManager entityManager) {

    this.entityManager = entityManager;
    this.entityClass = getClassObject();
  }

  abstract Class<T> getClassObject();


  @Override
  public void create(T t) {

    entityManager.persist(t);
  }

  @Override
  public T find(ID id) {
    return entityManager.find(getClassObject(), id);


  }

  @Override
  public T update(T t) {

    t = entityManager.merge(t);

    return t;
  }

  @Override
  public void delete(ID id) {

    entityManager.createQuery("delete  from " + getClassObject().getSimpleName() + " e where e.id= :id")
      .setParameter("id", id)
      .executeUpdate();

  }

  @Override
  public List<T> findAll(T t) {
    TypedQuery<T> typedQuery =
      entityManager.createQuery("select t from" + entityClass.getSimpleName() + "t", entityClass);
    List<T> list = typedQuery.getResultList();
    return list;
  }

  @Override
  public void beginTransaction() {
    if (!entityManager.getTransaction().isActive()) {
      entityManager.getTransaction().begin();
    }

  }

  @Override
  public void commitTransaction() {
    entityManager.getTransaction().commit();

  }

  @Override
  public void rollbackTransaction() {
    entityManager.getTransaction().rollback();
  }

  @Override
  public EntityTransaction getTransaction() {
    return entityManager.getTransaction();
  }

  @Override
  public EntityManager getEntityManager() {
    return entityManager;
  }
}
