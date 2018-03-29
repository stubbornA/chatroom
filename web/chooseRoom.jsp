<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>聊天室</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        *{
            margin: 0;
            padding:0;
        }
        body{
            background: rgba(0,0,0,0);
            color: #ffffff;
            font-size: 30px;
            font-family: Gabriola;
        }
        table{
            background: rgba(255,255,255,0.2);
            color: #ffffff;
            font-weight: 900;
        }
        table tr{
            font-size: 25px;
            cursor: pointer;
        }
        table tr:hover{
            color: black;
        }
    </style>
</head>
<body>
<div style="height: 100px"></div>
<f:set var="roomlist" value="${requestScope.roomlist}"></f:set>
<div class="container">
    <form role="form">
        <div class="row clearfix" id="waitChoose">
        <div class="table-responsive">
            <table class="table table-hover" class="waitAuditTable" style="font-size: 18px;">
                <caption class="text-center"><h2 style="color: #ffffff">请选择聊天室类型</h2></caption>
                <thead>
                <tr>
                    <th>房间号</th>
                    <th>类型</th>
                </tr>
                </thead>
                <tbody>
                <f:forEach var="room" items="${roomlist}" varStatus="status" >
                <tr onclick="enterRoom(${room.getid()})">
                    <td>${status.index}</td>
                    <td>${room.getRoomname()}</td>
                </tr>
                </f:forEach>
                <%--<tr>--%>
                    <%--<td>2</td>--%>
                    <%--<td>夏日炎炎</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>3</td>--%>
                    <%--<td>秋风瑟瑟</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>4</td>--%>
                    <%--<td>白雪皑皑</td>--%>
                <%--</tr>--%>
                </tbody>
            </table>
        </div>
    </div>
    </form>
</div>

<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $('#backbtn').on('click',function () {
        history.go(-1);
    })
function enterRoom(roomid) {
    window.location="chat?action=enterRoomById&&roomid="+roomid;
}
</script>
</body>
</html>