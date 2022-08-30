package service;

import domain.Travel;

import java.time.LocalDate;
import java.util.List;

public interface TravelService extends BaseService<Travel,Integer> {

  List<Travel> findByDateAndCity(LocalDate date, String SourceCity, String DesCity);
}
