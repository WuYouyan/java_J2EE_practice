package dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import util.C3P0Util;

import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


    @Override
    public int addUser(User user) throws SQLException {
        String sql = "insert into t_user(name,pwd) values(?,?)";
        return qr.update(sql, new Object[]{user.getName(), user.getPwd()});
    }

    @Override
    public int deleteUserByName(String name) throws SQLException {
        String sql = "delete from t_user where name=?";
        return qr.update(sql, new Object[]{name});
    }

    @Override
    public User queryUser(User user) throws SQLException {
        String sql="select name,pwd from t_user where name=? and pwd=?";
        return qr.query(sql,new Object[]{user.getName(),user.getPwd()}, new BeanHandler<User>(User.class) );
    }

    public static void main(String[] args) throws SQLException {
        User user=new User("右严","123");
        int i=new UserDaoImpl().addUser(user);
        System.out.println(i);
    }
}
