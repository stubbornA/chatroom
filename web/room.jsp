<%@page contentType="text/html; ISO-8859-1" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="df" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        *{
            margin: 0;
            padding:0;
            border: 0px solid transparent !important;
        }
        body{
            background: rgba(0,0,0,0);
            color: white;
            font-size: 20px;
            font-family: Gabriola;
        }
        table{
            border: none;
        }
        table tr{
            border: none;
        }
        #chat,#members{
            height: 600px;
        }
        #chat .chatContent{
            height: 500px;
            overflow-y: auto;
            background: rgba(0,0,0,0);
        }
    </style>
</head>
<body>
<div style="height: 20px"></div>
<div class="container">
    <div class="row" id="main">
        <div class="col-md-9" id="chat" style="background: rgba(255, 255, 255, 0.2)">
            <h2 class="text-center">${requestScope.roomname}</h2>
            <div class="chatContent">
                <h3 style="font-size: 20px;color: white;border-bottom: solid 1px ">聊天内容</h3>
                <table class="table">
                    <tr><th width="20%"></th><th width="55%"></th><th width="25%"></th></tr>
                    <f:forEach var="content" items="${requestScope.contentlist}" >
                        <tr>
                            <td>${content.getUname()}</td>
                            <td>${content.getContent()}</td>
                            <td><df:formatDate value="${content.getDate()}" pattern="yyyy-MM-dd hh:mm:ss"></df:formatDate></td>
                        </tr>
                    </f:forEach>
                </table>
            </div>
            <form action="chat?action=addContent" class="form-horizontal" method="post">
                <input type="hidden" name="roomid" value="${requestScope.roomid}">
                <div class="form-group col-md-11">
                    <textarea class="form-control" name="content"  cols="30" rows="3" ></textarea>
                </div>
                <div class="form-group col-md-1">
                    <div class="center-block" style="margin-left:10px;margin-top: 40px">
                    <button class="btn btn-success " id="submit" type="submit">发送</button>
                     </div>
                </div>
            </form>
            <div class="publish">
            </div>
        </div>
        <div class="col-md-3" id="members" style="background: rgba(255, 255,255, 0.1);">
            <table class="table" style="border: none">
                <caption style="color: white">成员列表</caption>
                <thead>
                <tr>
                    <th> </th>
                </tr>
                </thead>
                <tbody>
                <f:forEach items="${requestScope.userlist}" var="username" step="1">
                <tr>
                    <td>${username}</td>
                </tr>
                </f:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function () {
        $('#backbtn').on('click',function () {
            history.go(-1);
        })
    })
</script>
</body>
</html>