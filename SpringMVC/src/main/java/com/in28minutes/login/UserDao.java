package com.in28minutes.login;

public interface UserDao {

	  void register(User user);

	  User validateUser(Login login);
	}

