<%--
  Created by IntelliJ IDEA.
  User: MaiBenBen
  Date: 2018/9/1
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>留言板后台管理</title>
</head>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
    $(function(){
        $.ajax({
            type : "get",
            url : "Message",
            dataType : "json",
            success: function (jsonData) {
                jsonData = JSON.stringify(jsonData);
                console.log(jsonData);
                jsonData = eval("(" + jsonData + ")");
                console.log(jsonData);
                document.write("<div align='center'>")
                document.write("<a href=\"messageBoard.jsp\">留言板</a>");
                show(jsonData);
                document.write("</div>")
            }
        })
    });


    function show(jsonData) {

        document.write("<table border=\"1\">");
        document.write("<tr>");
        document.write("<th>昵称</th>");
        document.write("<th>时间</th>");
        document.write("<th>内容</th>");
        document.write("<th>状态</th>");
        document.write("<th>修改</th>");
        document.write("</tr>");
        for (var i in jsonData) {
            document.write("<form id=\"form_sub_a\" action=\"<%=request.getContextPath()%>/Management\" method=\"post\">");
            document.write("<input type=\"hidden\" name=\"id\" value=\"" + jsonData[i]["id"] + "\"></p>");
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
            document.write("<td>");
            if(jsonData[i]["isVisable"]=="true"){
                document.write("<input type=\"hidden\" name=\"isVisable\" value=\"" + "false" + "\"></p>");
                document.write("可见");
                document.write("</td>");
                document.write("<td>");
                document.write("<input type=\"submit\" value=\"不可见\" />")
            } else {
                document.write("<input type=\"hidden\" name=\"isVisable\" value=\"" + "true" + "\"></p>");
                document.write("不可见");
                document.write("</td>");
                document.write("<td>");
                document.write("<input type=\"submit\" value=\"可见\" />")
            }
            document.write("</td>");
            document.write("</tr>");
            document.write("</form>")

        }
        document.write("</table>");
    }
</script>
<body>

</body>
</html>
