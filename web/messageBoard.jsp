<%--
  Created by IntelliJ IDEA.
  User: MaiBenBen
  Date: 2018/9/1
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>留言板</title>
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
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>

<body>
<div>
    <div >
        <script>
            $(function(){
                $.ajax({
                    type : "get",
                    url : "Message",
                    dataType : "json",
                    success: function (jsonData) {
                        document.write("<div align=\"center\" id=\"yuanjiao\" >");
                        document.write("<a href=\"submitMessage.jsp\">提交留言</a>");
                        jsonData = JSON.stringify(jsonData);
                        console.log(jsonData);
                        jsonData = eval("(" + jsonData + ")");
                        console.log(jsonData);
                        show(jsonData);
                        document.write("</div>");
                    }
                })
            });


            function show(jsonData) {
                document.write("<table border=\"1\">");
                document.write("<tr>");
                document.write("<th>昵称</th>");
                document.write("<th>时间</th>");
                document.write("<th>内容</th>");
                document.write("</tr>");
                for (var i in jsonData) {
                    if(jsonData[i]["isVisable"] == "true"){
                        document.write("<tr>");
                        document.write("<td>");
                        document.write(jsonData[i]["username"]);
                        document.write("</td>");
                        document.write("<td>");
                        document.write(jsonData[i]["time"]);
                        document.write("</td>");
                        document.write("<td>");
                        document.write(jsonData[i]["details"]);
                        document.write("</td>");
                        document.write("</tr>");
                    }
                }

                document.write("</table>");
            }
        </script>
    </div>
</div>
</body>
</html>
