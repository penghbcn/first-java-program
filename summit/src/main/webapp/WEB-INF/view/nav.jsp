<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="navbar-header">
    <a class="navbar-brand" href="#"><img src="image/logo.png" height="50px"></a>
</div>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul id="newstype" class="nav navbar-nav">
        <li class="active">
            <a href="#">热门</a>
        </li>
        <li>
            <a href="#">政治</a>
        </li>
        <li>
            <a href="#">军事</a>
        </li>
        <li>
            <a href="#">经济</a>
        </li>
        <li>
            <a href="#">时尚</a>
        </li>
        <li>
            <a href="#">美食</a>
        </li>
        <li>
            <a href="#">游戏</a>
        </li>
        <li>
            <a href="#">动漫</a>
        </li>
    </ul>

    <ul id="userinfo" class="nav navbar-nav navbar-right">
        <!--根据ajax获取是否登陆动态加载-->
    </ul>
    <form class="navbar-form navbar-right" role="search" onsubmit="return search()">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="新闻"/>
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
    </form>
</div>