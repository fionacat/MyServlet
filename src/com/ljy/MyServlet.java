package com.ljy;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class MyServlet extends HttpServlet {
    String username;
    String password;
    boolean isAdmin;
    Dao mysql = new Dao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        //获得表单提交的数据
        username = request.getParameter("user");
        password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);
        Connection connection = mysql.getConnection();
        PrintWriter out = response.getWriter();
        isAdmin = mysql.isAdmin(connection,username,password);
        if(isAdmin == true) {
            out.println("<script>alert('登陆成功,进入留言板管理界面');window.location.href='messageManagement.jsp';</script>");
        } else {
            out.println("<script>alert('登录失败，进入留言板界面');window.location.href='messageBoard.jsp';</script>");
        }
    }
}
