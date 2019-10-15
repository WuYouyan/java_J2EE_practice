package servlet;

import javax.servlet.*;
import java.io.IOException;

public class MyServlet implements Servlet{
    //这个类不用看，了解知识用的
    public MyServlet(){
        System.out.println("first");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}