package com.ljy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
@WebServlet(name = "MyServlet")
public class Management extends HttpServlet {
    Dao mysql = new Dao();
    public static String id;
    public static String isVisable;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        id = req.getParameter("id");
        isVisable = req.getParameter("isVisable");
        Connection connection = mysql.getConnection();
        PrintWriter out = resp.getWriter();
        if(mysql.editMsgVisable(connection,id,isVisable)){
            out.println("<script>alert('修改成功！跳转到留言板界面！');window.location.href='messageManagement.jsp';</script>");
        } else {
            out.println("<script>alert('修改失败！');window.location.href='messageManagement.jsp';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
