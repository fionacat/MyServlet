package com.ljy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet(name = "MyServlet")
public class Message extends HttpServlet{
    Dao mysql = new Dao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Connection conn = mysql.getConnection();
        ResultSet rs = mysql.getResultSet(conn);
        String json = mysql.DataToJson(rs);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(json);
    }
}
