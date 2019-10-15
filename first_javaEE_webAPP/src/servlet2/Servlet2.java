package servlet;

import entity.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw= response.getWriter(); //默认对输出内容使用iso-8859-1编码

        //调用HttpServletRequest的api方法来获取客户端传过来的请求数据
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        //创建业务层对象
        IUserService us = new UserServiceImpl();
        User result = us.queryUser(new User(name, pwd));
        if (result != null) {
            pw.println("<script>javascript:alert('登陆成功')</script>");
//            response.sendRedirect("login.html");
        }else{
            pw.println("<script>javascript:alert('用户名或密码错误')</script>");
//            response.sendRedirect("login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
