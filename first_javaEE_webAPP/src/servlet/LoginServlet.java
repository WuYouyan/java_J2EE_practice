package servlet;

import service.IUserService;
import service.UserServiceImpl;
import  entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




public class LoginServlet extends HttpServlet {
    //DIY doing something
    private String message;

    @Override
    public void init() throws ServletException{
        message =  "Hello world, this message is from LoginServlet!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //do something when get request
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter(); //默认对输出内容进行iso-8859-1编码

        //调用HttpServletRequest的api方法来获取客户端传过来的数据
        String name = request.getParameter("name");
        String password = request.getParameter("");

        // 创建业务层对象
        IsuerService us = new UserServiceImpl();
        User result = us.queryUser(new User(name,password));
        if(result != null){
            pw.println("<script>javascript:alert('登录成功')</script>");
            response.sendRedirect(login.html);
        }
        else{
            pw.println("<script>javascript:alert('用户名或密码错误')</script>");
            response.sendRedirect(login.html);
        }
    }
    @Override
    public  void destroy(){
        super.destroy();
    }
}
