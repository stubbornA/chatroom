<%@page contentType="text/html; ISO-8859-1" pageEncoding="utf-8" language="java" %>
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
            color: #ffffff;
            font-size: 30px;
            font-family: Gabriola;
        }
    </style>
</head>
<body>
<div  style="position:fixed;z-index:-1;height: 100%;width: 100%;">
    <img src="img/show.jpg" alt="" height="100%" width="100%">
</div>
<div style="height: 100px"></div>
<div class="container">
    <div class="row">
       <p class="center-block" style="color: white">
           ${requestScope.msg==null?"":requestScope.msg}
       </p>
    </div>
</div>

<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $('#backbtn').on('click',function () {
        history.go(-1);
    })
</script>
</body>
</html>