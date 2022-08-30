package repository;

import domain.Travel;

import javax.persistence.EntityManager;

public class TravelRepositoryImpl extends BaseRepositoryImpl<Travel,Integer> implements TravelRepository {
  public TravelRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  Class<Travel> getClassObject() {
    return Travel.class;
  }
}
