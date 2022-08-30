package service;

import domain.TravelCompany;
import repository.TravelCompanyRepository;

import java.util.List;

public class TravelCompanyServiceImpl extends BaseServiceImpl<TravelCompany,Integer, TravelCompanyRepository> implements TravelCompanyService {
  public TravelCompanyServiceImpl(TravelCompanyRepository repository) {
    super(repository);
  }

  @Override
  public TravelCompany findByeCompanyName(String CompanyName) {
    List<TravelCompany> travelCompanies = repository.getEntityManager().createQuery("select t from TravelCompany t where t.name= :name", TravelCompany.class)
      .setParameter("name", CompanyName).getResultList();
    if (!travelCompanies.isEmpty())return travelCompanies.get(0);
    else return null;

  }
}
