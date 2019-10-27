package servlet;

import service.UserServiceImpl;
import service.IUserService;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.TimerTask;
//import java.util.Timer;

public class LoginServlet extends HttpServlet {
    //DIY doing something
    private String message;

    @Override
    public void init() throws ServletException{
        message =  "Success! this message is from LoginServlet!";
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
        String password = request.getParameter("password");

        // 创建业务层对象
        IUserService us = new UserServiceImpl();
        User result = us.queryUser(new User(name,password));
        if(result != null){
            pw.println("<script>javascript:console.log('登录成功');</script>");
//            response.sendRedirect(request.getContextPath()+"login.html");
            pw.println("<p style='color:red'>"+message+ "</p>" +" name:（用户名） "+name+"<br> pwd :（密码）"+ password);
        }
        else {
//            pw.println("<script>javascript:alert('用户名或密码错误');</script>");
            pw.write("<h3 style='color:red'>用户名或密码错误 <br> 3s 后回到登陆界面</h3>");
            response.setHeader("refresh","3;"+request.getContextPath()+"login.html");
//            pw.println("<script>javascript:window.location.href = \"localhost:8080/login.html\";</script>");

        }
    }
    @Override
    public  void destroy(){
        super.destroy();
    }

//    public static void main(String[] args){
//        new Timer().schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                System.out.println("test");
//            }
//
//        },2000);
//    }
}
