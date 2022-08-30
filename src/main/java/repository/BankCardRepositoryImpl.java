package repository;

import util.BankCard;

import javax.persistence.EntityManager;

public class BankCardRepositoryImpl extends BaseRepositoryImpl<BankCard,Long> implements BankCardRepository {
  public BankCardRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  Class<BankCard> getClassObject() {
    return BankCard.class;
  }
}
