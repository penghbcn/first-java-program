<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>login</title>

<link href="../../src/main/resources/static/css/bootstrap.min.css" rel="stylesheet">
<link href="../../src/main/resources/static/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="../../src/main/resources/static/css/register-login.css" rel="stylesheet">

<script src="../../src/main/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="../../src/main/resources/static/js/bootstrap.min.js"></script>
<script src="../../src/main/resources/static/js/cookie.js"></script>
<script src="../../src/main/resources/static/js/login.js"></script>
</html>
<body>

<div class="container">
    <div class="row clearfix" style="top: 50px">
        <nav id="nav" class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="javascript:index()"><img src="../../src/main/resources/static/image/logo.png" height="50px"></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul id="userinfo" class="nav navbar-nav navbar-right">
                    <li><a href='javascript:register()'>免费注册</a></li>
                </ul>
            </div>
        </nav>
        <div class="col-md-5 column"></div>
        <div class="col-md-2 column col-center-block">

            <form class="form-horizontal" role="form" onsubmit="return checkLoginForm()">
                <div class="form-group col-sm-offset-3" style="text-align: center">
                    <label><h2>欢迎登录</h2></label>
                </div>
                <div class="form-group">
                    <div>
                        <label for="loginUsername" class="control-label">Email/Tel/Username</label>
                    </div>
                    <div>
                        <input name="username" class="form-control" id="loginUsername"/>
                        <span></span>
                    </div>
                </div>
                <div class="form-group">
                    <div>
                        <label for="loginPassword" class="control-label">Password</label>
                    </div>
                    <div>
                        <input name="password" type="password" class="form-control" id="loginPassword"/>
                        <span></span>
                    </div>
                </div>
                <div class="form-group ">
                    <div class="checkbox">
                        <label style="width: 49%"><input type="checkbox"/>记住我</label>
                        <label style="width: 49%"><input type="checkbox"/>自动登录</label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-10">
                        <button type="reset" class="btn btn-default">重置</button>
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-5 column"></div>
    </div>
</div>
</body>