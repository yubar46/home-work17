package service;

import domain.User;

public interface UserService extends BaseService<User,Integer> {

User findByUsername(String username);


}
