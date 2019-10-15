import entity.User;
import service.IUserService;
import service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        //手动测试类是否运行成功
        IUserService us=new UserServiceImpl();

        User user=new User("youyan","123");
        int row=us.addUser(user);
        if(row==1){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }


    }

}
