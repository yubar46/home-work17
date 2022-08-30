package service;

import domain.TravelCompany;

public interface TravelCompanyService extends BaseService<TravelCompany,Integer> {

  TravelCompany findByeCompanyName(String airLineName);
}
