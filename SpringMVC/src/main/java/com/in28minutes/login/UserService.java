package com.in28minutes.login;

public interface UserService {

  void register(User user);

  User validateUser(Login login);
}
