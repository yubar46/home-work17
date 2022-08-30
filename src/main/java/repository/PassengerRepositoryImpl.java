package repository;

import domain.User;

import javax.persistence.EntityManager;

public class PassengerRepositoryImpl extends BaseRepositoryImpl<User,Integer> implements PassengerRepository {
  public PassengerRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  Class<User> getClassObject() {
    return User.class;
  }
}
