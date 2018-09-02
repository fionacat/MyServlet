package com.ljy;

import java.sql.*;

public class Dao {

    static public Connection connection;
    //连接数据库
    static public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/message_board?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT","root","ljy314986,");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("连接数据库成功");
        return connection;
    }

    //判断是否为管理员
    static public boolean isAdmin(Connection connection,String name,String password){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from admin where adminName='" + name +"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("adminPassword").equals(password)){
                    System.out.println(rs.getString("adminPassword"));
                    return true;
                }
            }
        } catch (SQLException e ){
            return false;
        }
        return false;
    }
    //获取数据库中的数据
    public static ResultSet getResultSet(Connection connection){
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from message";
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
    }

    //将数据库中的数据转为json
    public static String DataToJson(ResultSet rs){
        String json = null;
        json = "[";
        try {
            while (rs.next()) {
                json = json + "{\"id\":\"";
                json = json + rs.getString("id");
                json = json + "\",\"username\":\"";
                json = json + rs.getString("username");
                json = json + "\",\"details\":\"";
                json = json + rs.getString("details");
                json = json + "\",\"time\":\"";
                json = json + rs.getString("time");
                json = json + "\",\"isVisable\":\"";
                json = json + rs.getString("isVisable");
                json = json + "\"},";
            }
        } catch (SQLException e) {
        }
        json = json.substring(0,json.length() - 1);
        json = json + "]";
        System.out.println(json);
        return json;
    }

    //提交留言
    public static boolean submitMessage(Connection connection,String user,String message,String time){
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO message (`username`,`details`,`time`,`isVisable`) VALUES ( ?,?,?,?)");
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,message);
            preparedStatement.setString(3,time);
            preparedStatement.setString(4,"false");

            preparedStatement.executeUpdate();
            System.out.println("添加留言成功，请等待审核");
            statement.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    //修改留言是否可见
    public static boolean editMsgVisable(Connection connection,String id,String isVisable){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update message set isVisable = ? where id = ?");
            preparedStatement.setString(1,isVisable);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            return false;
        }
        return true;
    }
}
