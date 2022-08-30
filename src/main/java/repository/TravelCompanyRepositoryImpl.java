package repository;

import domain.TravelCompany;

import javax.persistence.EntityManager;

public class TravelCompanyRepositoryImpl extends BaseRepositoryImpl<TravelCompany,Integer> implements TravelCompanyRepository {
  public TravelCompanyRepositoryImpl(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  Class<TravelCompany> getClassObject() {
    return TravelCompany.class;
  }
}
