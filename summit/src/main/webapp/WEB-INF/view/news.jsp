<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>MyNews</title>

<link href="../../src/main/resources/static/css/bootstrap.min.css" rel="stylesheet">
<!--<link href="css/bootstrap-theme.min.css" rel="stylesheet">-->
<link href="../../src/main/resources/static/css/index.css" rel="stylesheet">

<script src="../../src/main/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="../../src/main/resources/static/js/bootstrap.min.js"></script>
<script src="../../src/main/resources/static/js/local.js"></script>
</html>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    Example page header <small>Subtext for header</small>
                </h1>
            </div>
            <ul class="breadcrumb">
                <li>
                    <a href="#">Home</a>
                </li>
                <li class="active">
                    Data
                </li>
            </ul>
            <p>
                <em>Git</em> 是一个分布式的版本控制系统，最初由 <strong>Linus Torvalds</strong> 编写，用作Linux内核代码的管理。在推出后，Git在其它项目中也取得了很大成功，尤其是在 <small>Ruby</small> 社区中。
            </p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <button type="button" class="btn btn-default">按钮</button>
        </div>
    </div>
    <hr>
    <div class="row clearfix">
        <div class="col-md-1 column">
        </div>
        <div class="col-md-1 column">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <span class="label label-default">标签</span>
                </div>
                <div class="col-md-4 column">
                    <span class="label label-default">标签</span>
                </div>
                <div class="col-md-4 column">
                    <span class="label label-default">标签</span>
                </div>
            </div>
        </div>
        <div class="col-md-1 column">
        </div>
        <div class="col-md-9 column">
        </div>
    </div>
    <hr>
    <div class="row clearfix">
        <div class="col-md-9 column">
            <form role="form">
                <div class="form-group">
                    <label for="exampleInputEmail1">发表评论</label><textarea type="text" class="form-control" id="exampleInputEmail1" ></textarea>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
        <div class="col-md-3 column">
        </div>
    </div>
</div>
</body>