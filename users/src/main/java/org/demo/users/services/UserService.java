package org.demo.users.services;

import java.util.List;

import org.demo.users.domain.User;

public interface UserService {
	public User getForUsername(String username);
    public List<User> getAllUsers();
    public void createUser(User user);
}
