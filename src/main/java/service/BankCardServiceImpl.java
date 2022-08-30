package service;

import util.BankCard;
import repository.BankCardRepository;

public class BankCardServiceImpl extends BaseServiceImpl<BankCard,Long, BankCardRepository> implements BankCardService {
  public BankCardServiceImpl(BankCardRepository repository) {
    super(repository);
  }


}
