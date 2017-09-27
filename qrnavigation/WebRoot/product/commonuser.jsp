<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <title>景区信息平台</title>
    <meta http-equiv="Cache-Control" content="no-transform" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="alternate" href="http://m.588ku.com/?h=bd&sem=1" />
    <meta name="mobile-agent" content="format=html5;url= http://m.588ku.com/?h=bd&sem=1" />
    <script type="text/javascript">
        var now=new Date();var beginTime=now.getTime();var b = 1;
    </script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/baseV6.css?545" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.1.12.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jqueryeasyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/indexV5.css?545">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/red-pack.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jqueryeasyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jqueryeasyui/themes/icon.css">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript">

        var default_open = 1;
        function logout(){
            if(confirm('确定退出系统？')){
                $.getJSON('${pageContext.request.contextPath}/userController/logout', {
                    t : new Date()
                }, function(result) {
                        if(result.success){
                            location.replace('${pageContext.request.contextPath}/');
                        }
                });
            }
        }
        /*账号修改*/
        function fixcommonsuser(data){
            $.post('${pageContext.request.contextPath}/userController/findcommonsuser', {userId:data}, function(result) {
                var ss = JSON.parse(result);
                if(ss.success){

                    alert("账号修改成功");
                }
            });
        }
        /*二维码修改*/
        function fixProductCode(qrId) {
            $.post('${pageContext.request.contextPath}/userController/login', {qrcodeId:qrId}, function(result) {
                var ss = JSON.parse(result);
                if(ss.success){

                    alert("二维码修改成功");
                }
            });
        }
    </script>

</head>
<body>
<div class="head-top-nav">
    <div class="w1200 clearfix">
        <div class="logo-wrap fl"><a href="#"></a></div>
        <div class="top-nav-menu fl">			</div>
        <div class="login-wrap fr"><!-- 未登录 -->
            <ul class="clearfix" >
                <li class="fl"><a>欢迎您:</a><h4>${commonsUser.userLoginName}</h4></li>
                <li class="fl"><a class="fix-reg fix" href="" onclick="fixcommonsuser(${commonsUser.userId});return false;"  rel="nofollow" id="login_weixin3">修改</a></li>
                <li class="fl"><a class="loginOr-reg login" href="" onclick="logout();return false;"  rel="nofollow" id="login_weixin2">退出</a></li>
            </ul>
        </div>
    </div><!-- 下拉列表 -->
</div>
<%--景区简介--%>
<div class="intro-show">

</div>

<div class="qk-index-wrapper">
    <div class="w1200"><!-- 元素推荐 -->
        <div id="png-floor" class="imgRecom-box pngRecom-box">

            <h2 class="clearfix">
                <em class="fl mod-icon"></em>
                <a class="title fl" href="" target="_blank">西藏景区二维码导览已制作列表</a>
                <a class="check-more fr" href="${pageContext.request.contextPath}/productController/addPage" >开始制作<i></i></a>
            </h2>
            <div class="png-list">
                <c:forEach items="${commonList}" var="product">
                <ul class="clearfix img-hover-animate">
                    <li class="fl">
                        <div class="img-show">
                            <div class="img-box-link">
                                <a class="img-part" href="${pageContext.request.contextPath}/product/${product.scenicspotLink}" target="_blank">
                                    <img class="lazy" src="${product.qrcodeLink}"          data-original="${product.qrcodeLink}"
                                         alt="" title="" onclick="fixProductCode(${product.qrcodeId})"><!--hover蒙版-->
                                    <div class="mask-tier"></div>
                                </a>
                                <div class="hover-content bglist_8559440" style="display: block">

                                    <a href="${pageContext.request.contextPath}/productController/export_png?id=${product.qrcodeId}" target="_blank" alt="下载二维码" class="down-big-img fr" >PNG<i></i>
                                    </a>
                                    <a href="${pageContext.request.contextPath}/productController/delete?id=${product.qrcodeId}" onclick="return confirm('确定删除?');" alt="删除二维码" class="favV2 nonofavV2" data="8559440">
                                        X
                                    </a>
                                </div>
                            </div>
                        </div>
                        <a class="img-tit" href="" >${product.scenicspotName}二维码图片</a><!--底部阴影-->

                        <div class="shadow-b"></div>
                    </li>
                    </c:forEach>

            </div><!-- 背景推荐 -->
        </div>
    </div>
</div>

<div class="web-bottom">
    <div class="bottom-con w1200 clearfix"><p>西藏景区系统<a href="#" >Copyright © 2017 西藏景优</a>
    </div>
</div>
<%--修改窗口--%>


<script type="text/javascript">
    var globaluid = 1;

    $(window).load(function() {
        $("img.lazy").lazyload({
            effect: "fadeIn",
            threshold : 300,
            failurelimit:10
        });
    });
</script>

<script type="text/javascript">
    var videotime;
    var lasttime=0;


    $(window).load(function() {

        $("img.lazy").lazyload({
            effect: "fadeIn",
            threshold : 300,
        });


        //加载视频图片资源
        var imgurl = $('.intro-box .intro-pic a').attr("data-url");
        $('.intro-box .intro-pic a').append('<img src="'+imgurl+'"/>');
        var imgurl = $('.intro-video a').attr("data-url");
        $('.intro-video a').append('<img src="'+imgurl+'"/>');


        var d = new Date();
        var a = d.getTime();
        var c = (a - beginTime) / 1000;

        $("#exectime").html(" " + c + " 秒");
        var tp_cost_time = 0.0084;
        //$.get('http://ajax.588ku.com/index.php?m=ajax&a=page_cost&exec_time=' + c + '&tp_cost_time=' + tp_cost_time + '&type=' + b);

    });
    $(".search-fixTop").searchFixTop();



    // 滑动锚点
    $('#left-anchor a').on('click', function() {
        var anchor = $(this).attr('data-anchor');
        $('body,html').stop().animate({
            scrollTop: $(anchor).offset().top - 40
        }, 400);
        return false;
    })
</script>
</body>
</html>
