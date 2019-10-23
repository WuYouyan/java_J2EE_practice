package service;

import dao.IUserDao;
import dao.UserDaoImpl;
import entity.User;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public int addUser(User user) {
        try {
            return userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUserByName(String name) {
        try {
            return userDao.deleteUserByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int updateUserPassword(User user){
        try{
            return userDao.updateUserPassword(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }



    @Override
    public User queryUser(User user) {
        try {
            return userDao.queryUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
