package service;

import entity.User;

public interface IUserService {
    public int addUser(User user);
    public int deleteUserByName(String name);
    public int updateUserPassword(User user);
    public User queryUser(User user);
}
