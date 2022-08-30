package service;

import domain.User;
import repository.PassengerRepository;

public class UserServiceImpl extends BaseServiceImpl<User,Integer, PassengerRepository> implements UserService {
  public UserServiceImpl(PassengerRepository repository) {
    super(repository);
  }


  @Override
  public User findByUsername(String username) {
    return repository.getEntityManager().createQuery("select u from  User u where u.userName=:username",User.class).
      setParameter("username",username).getResultList().get(0);
  }
}
