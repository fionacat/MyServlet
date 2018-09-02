<%--
  Created by IntelliJ IDEA.
  User: MaiBenBen
  Date: 2018/8/24
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>管理员登陆</title>
  <style type="text/css">
    #yuanjiao{
      font-family: Arial;
      border: 2px solid #FFEFDB;
      border-radius: 20px;
      background-color: #8fcde7;
      padding: 30px 30px;
      width: 330px;
    }
  </style>
</head>
<body>
<div>
  <div align="center">
    <div  id="yuanjiao">
      <p style="font-family: 黑体;font-size: 30px">管理员登陆</p>
      <form id="form_sub_a" action="<%=request.getContextPath()%>/MyServlet" method="post">
        <p style="font-family: 微软雅黑">账号：<input type="text" name="user" /></p>
        <p style="font-family: 微软雅黑">密码：<input type="password" name="password" /></p>
        <input type="submit" value="登录" />
        <%--<input type="reset" value="取消" />--%>
      </form>
      <p></p>
      <a href="messageBoard.jsp">留言板</a>
      <a href="submitMessage.jsp">提交留言</a>
    </div>
  </div>
</div>

</body>
</html>
