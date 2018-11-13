<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Register</title>

<link href="../../src/main/resources/static/css/bootstrap.min.css" rel="stylesheet">
<link href="../../src/main/resources/static/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="../../src/main/resources/static/css/register-login.css" rel="stylesheet">

<script src="../../src/main/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="../../src/main/resources/static/js/bootstrap.min.js"></script>
<script src="../../src/main/resources/static/js/cookie.js"></script>
<script src="../../src/main/resources/static/js/register.js"></script>
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
                    <li><a href='javascript:login()'>登录</a></li>
                </ul>
            </div>
        </nav>
        <div class="col-md-5 column"></div>
        <div class="col-md-2 column col-center-block">
            <form id="registerForm" role="form" onsubmit="return checkRegisterForm()">
                <div class="form-group col-sm-offset-3">
                    <label ><h2>欢迎注册</h2></label>
                </div>
                <div class="form-group">
                    <label for="registerUsername">用户名</label><input name="username" type="text" class="form-control"
                                                                    id="registerUsername"/><span></span>
                </div>
                <div class="form-group">
                    <label for="registerPassword1">密码</label><input name="password1" type="password"
                                                                    class="form-control"
                                                                    id="registerPassword1"/><span></span>
                </div>
                <div class="form-group">
                    <label for="registerPassword2">确认密码</label><input name="password2" type="password"
                                                                      class="form-control"
                                                                      id="registerPassword2"/><span></span>
                </div>
                <div class="form-group col-sm-6">
                    <input id="userAgreementCheckBox" type="checkbox"/><a id="modal-405399" href="#modal-container-405399" role="button"
                                                                          class="btn" data-toggle="modal">用户协议</a>
                </div>
                <div class="col-sm-6">
                    <button type="submit" class="btn btn-default">确认注册</button>
                </div>
            </form>
        </div>
        <div class="col-md-5 column"></div>
        <div class="modal fade" id="modal-container-405399" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">用户协议</h4>
                    </div>
                    <div class="modal-body">还没写，随便注册~</div>
                    <div class="modal-footer">
                        <button id="userAgreementN" type="button" class="btn btn-default" data-dismiss="modal">拒绝</button>
                        <button id="userAgreementY" type="button" class="btn btn-primary" data-dismiss="modal">接受</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>