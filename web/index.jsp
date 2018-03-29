<%--
  Created by IntelliJ IDEA.
  User: fangjiejie
  Date: 2017/11/17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
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
    }
    body{
      background: rgba(0,0,0,0);
    }
    a{
      text-decoration: none;
    }
    ul{
      list-style:none;
    }
    #menu{
      margin-top: 5px;
      background: #013d55;
      box-shadow: 0px 0px 5px 6px #01596f;
    }
    #menu .navbar{
      margin-bottom: 0px;
    }
    #menu .operate ul li a{
      color: white;
    }
    #content{
      margin-top: 15px;
      box-shadow: 0px 0px 5px 6px #01596f;
      background: rgba(255,255,255,0.1);
    }
    #contentiframe{
      height: 700px;
    }
    .show{
      display: block;
    }
  </style>

</head>
<body>
<canvas id="canvas" style="position:fixed;z-index:-1;height: 100%;width: 100%;"></canvas>
<f:set var="user" value="${sessionScope.user}"></f:set>
<div class="container">
  <nav class="navbar navbar-default" role="navigation" style="margin-bottom: 0px;border: none" id="menu">
    <div class="container-fluid">
      <div class="navbar-header left">
        <a class="navbar-brand" href="#" style="color: #ffffff">欢迎 <span>${user==null?"游客":user.username} </span> 来到聊天室</a>
      </div>
      <div class="center-block">

      </div>
      <div class="operate">
        <ul class=" nav navbar-nav navbar-right" >
          <%--<li><a href="room.jsp" target="show">进入聊天室</a></li>--%>
          <f:if test="${user==null}">
          <button type="button" class="btn btn-success" style="margin: 6px 0px"><a href="login.jsp" target="show" style="color: white">登录</a></button>
          <button type="button" class="btn btn-primary" style="margin: 6px 3px"><a href="register.jsp" target="show" style="color: white">注册</a></button>
          </f:if>
          <f:if test="${user!=null}">
            <li><a href="chat?action=queryAllChatRoom" target="show">选择聊天室</a></li>
            <li id="fullscreen"><a href="#" ><span class="glyphicon glyphicon-resize-full "></span></a></li>
            <li><a href="user?action=out" ><span class="glyphicon glyphicon-log-out "></span></a></li>
          </f:if>
        </ul>
      </div>
    </div>
  </nav>
  <div id="content">
    <iframe src="${user==null?"show.jsp":"chat?action=queryAllChatRoom"}" id="contentiframe" name="show" width="100%" style="border: none">
    </iframe>
  </div>
</div>
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/milkybg.js"></script>
<script>
  //控制全屏
  function enterfullscreen() {//进入全屏
    var docElm = document.documentElement;
//W3C
    if (docElm.requestFullscreen) {
      docElm.requestFullscreen();
    }
//FireFox
    else if (docElm.mozRequestFullScreen) {
      docElm.mozRequestFullScreen();
    }
//Chrome等
    else if (docElm.webkitRequestFullScreen) {
      docElm.webkitRequestFullScreen();
    }
//IE11
    else if (elem.msRequestFullscreen) {
      elem.msRequestFullscreen();
    }
  }
  function exitfullscreen() { //退出全屏
    if (document.exitFullscreen) {
      document.exitFullscreen();
    }
    else if (document.mozCancelFullScreen) {
      document.mozCancelFullScreen();
    }
    else if (document.webkitCancelFullScreen) {
      document.webkitCancelFullScreen();
    }
    else if (document.msExitFullscreen) {
      document.msExitFullscreen();
    }
  }
  var a=0;
  $('#fullscreen').on('click',function () {
    a++;
    a%2==1?enterfullscreen():exitfullscreen();
  })
</script>
</body>
</html>
