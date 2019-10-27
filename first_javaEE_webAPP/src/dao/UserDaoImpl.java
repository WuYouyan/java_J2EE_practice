package dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.springframework.jdbc.core.JdbcTemplate;
import util.C3P0Util;

import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

    @Override
    public int addUser(User user) throws SQLException {
        String sql = "insert into user(name,pwd) values (?,?)";
        return qr.update(sql, new Object[]{user.getName(), user.getPwd()});
    }

    @Override
    public int deleteUserByName(String name) throws SQLException {
        String sql = "delete from user where name=?";
        return qr.update(sql, new Object[]{name});
    }

    @Override
    public int updateUserPassword(User user) throws  SQLException{ // Upate password
        String sql = "update user set pwd=? where name=?";
        return qr.update(sql, new Object[]{user.getPwd(),user.getName()});
    }

    @Override
    public User queryUser(User user) throws SQLException {
        String sql="select name,pwd from user where name=? and pwd=?";
        return qr.query(sql, new BeanHandler<User>(User.class) ,new Object[]{user.getName(),user.getPwd()});
    }

    public static void main(String[] args) throws SQLException {
        User user=new User("右严","123");
//        int i=new UserDaoImpl().addUser(user); //test addUser()
        User i=new UserDaoImpl().queryUser(user);
        System.out.println(i.toString());
    }
}
