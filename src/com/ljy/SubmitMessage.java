package com.ljy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;

@WebServlet(name = "MyServlet")
public class SubmitMessage extends HttpServlet{
    Dao mysql = new Dao();
    public static String username;
    public static String details;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        username = req.getParameter("username");
        details = req.getParameter("details");
        Connection connection = mysql.getConnection();
        Long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        PrintWriter out = resp.getWriter();
        if(mysql.submitMessage(connection,username,details,sdf.format(time))){
            out.println("<script>alert('留言成功！等待审核！');window.location.href='messageBoard.jsp';</script>");
        } else {
            out.println("<script>alert('留言失败！请重试！');window.location.href='messageBoard.jsp';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
