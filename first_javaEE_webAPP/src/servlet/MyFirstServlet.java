package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyFirstServlet extends HttpServlet {
    //DIY doing something
    private String message;

    @Override
    public void init() throws ServletException{
        message =  "Hello world, this message is from MyFirstServlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //set the type of the responsive content
        resp.setContentType("text/html");

        //set the implementation of logic
        PrintWriter out = resp.getWriter();
        out.println("<h1>"+message+"doGet"+"</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //set the type of the responsive content
        resp.setContentType("text/html");

        //set the implementation of logic
        PrintWriter out = resp.getWriter();
        out.println("<h1>"+message+"doPost"+"</h1>");
    }
    @Override
    public  void destroy(){
        super.destroy();
    }
}
