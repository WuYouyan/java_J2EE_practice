package dao;

import entity.User;

import java.sql.SQLException;

public interface IUserDao {
    public int addUser(User user) throws SQLException;


    public int deleteUserByName(String name) throws SQLException;

    public int updateUserPassword(User user) throws  SQLException;

    public  User queryUser(User user) throws SQLException;
}
