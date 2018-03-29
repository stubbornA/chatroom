<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            /*font-family: Gabriola;*/
        }
        input{
            margin-top: 5px;
        }
    </style>
</head>
<body>
<div style="height: 100px"></div>
<div class="container">
    <div class="row">
        <form class="form-horizontal" role="form" target="_parent" method="post" action="user?action=login">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="username" id="firstname" placeholder="请输入账号" required>
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" name="password" id="lastname" placeholder="请输入密码" required>
                </div>
            </div>
            <div class="col-sm-12 form-group" style="margin-top: 15px">
                <div class="btn-group center-block" style="width: 160px">
                    <button type="button" id="backbtn" class="btn btn-default center-block">&nbsp;<span class="glyphicon glyphicon-circle-arrow-left"></span> 返回&nbsp;</button>
                    <button type="submit" class="btn btn-success center-block" id="formsubmit">&nbsp;<span class="glyphicon glyphicon-saved"></span> 登录&nbsp;</button>
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