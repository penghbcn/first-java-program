<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<ol class="carousel-indicators">
    <li class="active" data-slide-to="0" data-target="#thumbnail">
    </li>
    <li data-slide-to="1" data-target="#thumbnail">
    </li>
    <li data-slide-to="2" data-target="#thumbnail">
    </li>
</ol>
<div class="carousel-inner">
    <div class="item active">
        <img alt="www.baidu.com" src="v3/default.jpg"/>
        <div class="carousel-caption">
            <h4>
                First Thumbnail label
            </h4>
            <p>
                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida
                at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
            </p>
        </div>
    </div>
    <!--动态加载轮播图片-->
    <div class="item">
        <img alt="#" src="v3/default1.jpg"/>
        <div class="carousel-caption">
            <h4>
                Second Thumbnail label
            </h4>
            <p>
                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida
                at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
            </p>
        </div>
    </div>
    <div class="item">
        <img alt="#" src="v3/default2.jpg"/>
        <div class="carousel-caption">
            <h4>
                Third Thumbnail label
            </h4>
            <p>
                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida
                at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
            </p>
        </div>
    </div>
</div>
<a class="left carousel-control" href="#thumbnail" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>
<a class="right carousel-control" href="#thumbnail" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
</a>