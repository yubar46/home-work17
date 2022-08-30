package service;

import domain.Travel;
import repository.TravelRepository;

import java.time.LocalDate;
import java.util.List;

public class TravelServiceImpl extends BaseServiceImpl<Travel,Integer, TravelRepository> implements TravelService {
  public TravelServiceImpl(TravelRepository repository) {
    super(repository);
  }

  @Override
  public List findByDateAndCity(LocalDate date, String SourceCity, String DesCity) {
    return repository.getEntityManager().createQuery
      ("select t from Travel as t where t.travelDate= :travelDate and t.sourceCity= :soruceCity and t.destinationCity= :desCity order by t.travelTime ")
      .setParameter("soruceCity",SourceCity).setParameter("desCity",DesCity).setParameter("travelDate",date).getResultList();
  }
}
