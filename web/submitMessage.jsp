<%--
  Created by IntelliJ IDEA.
  User: MaiBenBen
  Date: 2018/9/1
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>提交留言</title>
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
        <div id="yuanjiao">
            <p style="font-family: 黑体;font-size: 30px">留言</p>
            <form id="form_sub_a" action="<%=request.getContextPath()%>/SubmitMessage" method="post">
                <p style="font-family: 微软雅黑">您的名字：<input type="text" name="username" /></p>
                <p style="font-family: 微软雅黑">留言内容：<input type="text" name="details" /></p>
                <input type="submit" value="留言" />
            </form>
            <a href="messageBoard.jsp">留言板</a>
        </div>
    </div>
</div>

</body>
</html>
