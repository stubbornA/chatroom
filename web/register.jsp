<%@page contentType="text/html; ISO-8859-1" pageEncoding="utf-8" language="java" %>
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
            color: white;
            font-size: 20px;
            font-family: Gabriola;
        }
    </style>
</head>
<body>
<div style="height: 100px"></div>
<div class="container">
    <div class="row">
        <form class="form-horizontal form" id="form2" role="form" action="user?action=register" method="post">
            <div class="form-group">
                <label class="col-sm-2 control-label name">账号 </label>
                <div class="col-sm-9">
                    <input type="text" class="form-control " name="username" required/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">密码 </label>
                <div class="col-sm-9">
                    <input type="password" class="form-control"  name="password"  required/>
                </div>
            </div>
            <div class="form-group repass" >
                <label  class="col-sm-2 control-label relable">重复密码 </label>
                <div class="col-sm-9" >
                    <input type="password" class="form-control"  name="repassword" required/>
                </div>
            </div>
            <div class="col-sm-12 form-group" style="margin-top: 15px">
                <div class="btn-group center-block" style="width: 160px">
                    <button type="button" id="backbtn" class="btn btn-default center-block">&nbsp;<span class="glyphicon glyphicon-circle-arrow-left"></span> 返回&nbsp;</button>
                    <button type="submit" class="btn btn-success center-block" id="formsubmit">&nbsp;<span class="glyphicon glyphicon-saved"></span> 提交&nbsp;</button>
                </div>
            </div>
        </form>
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