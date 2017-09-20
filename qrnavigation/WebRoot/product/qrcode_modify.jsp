<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<title>西藏景区二维码导览制作系统</title>
		<meta http-equiv="Cache-Control" content="no-transform" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="alternate" href="http://m.588ku.com/?h=bd&sem=1" />
	<meta name="mobile-agent" content="format=html5;url= http://m.588ku.com/?h=bd&sem=1" />
	<script type="text/javascript">
		var now=new Date();var beginTime=now.getTime();var b = 1;
    </script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/baseV6.css?545" />
	<script type="text/javascript" src="http://js.588ku.com/comp/base/js/jquery.min.js?545"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/indexV5.css?545">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/red-pack.css">
	<script type="text/javascript">
		$(function() {
			$('#form').form({
				url:'${pageContext.request.contextPath}/productController/add',
				onSubmit:function(){
					alert('');
				},
				success:function(result){
					
				}
			});
		});
		function uploadImage(){
			var image = document.getElementById("image").click();
			$("#scenicspot_bg").val(image);
			return image;
			 
		}
		function uploadWav(){
			var wav = document.getElementById("wav").click();
			$("#scenicspot_wav").val(wav);
			return wav;
			
		}
	</script>
</head>
<body>
	<div class="head-top-nav">
		<div class="w1200 clearfix">
			<div class="logo-wrap fl"><a href="" class="logo"></a></div>
			<div class="top-nav-menu fl">			</div>
			<div class="login-wrap fr"><!-- 未登录 -->
				<ul class="clearfix" >
					<!--<li class="fl tool"><a class="upload-btn tool-a" href="javascript:;" onclick="Login.phoneLogin();baiduTongji()" ><em class="tool-em"></em><span>上传</span></a></li>
					<li class="fl"><a class="loginOr-reg register" href="javascript:;" rel="nofollow" onclick="Login.phoneRegister();;baiduTongji()" id="login_qq2" >注册</a></li>-->
					<li class="fl"><a class="loginOr-reg login" href="javascript:;" onclick="Login.phoneLogin();baiduTongji()"  rel="nofollow" id="login_weixin2">退出</a></li>
				</ul>
			</div>
		</div><!-- 下拉列表 -->
	</div> 
	<div class="qk-index-wrapper">
		<div class="w1200"><!-- 元素推荐 -->
			<div id="png-floor" class="imgRecom-box pngRecom-box">
				<h2 class="clearfix">
					<em class="fl mod-icon"></em>
					<a class="title fl" href="" target="_blank">填写相关系信息</a>
				</h2>
				
			</div>
		</div>
	</div>
	<form id="form" method="post" enctype="multipart/form-data" action='${pageContext.request.contextPath}/productController/add'>
		<div class="search-bg">
			<div class="search-con w1200">
				<div class="clearfix" style="padding: 44px 0 10px;">
					<div class="search-tabBox"><ul class="search-tab">
						<li class="element-search selected">景区名称</li>
					</div> 
					<div class="search element">
						<input type="text" id="scenicspot_name" name="scenicspot_name" class="input-text fl" data-index="5" value="" placeholder="">
					</div>
				</div>	
				<div class="clearfix" style="padding: 0px 0 10px;">
					<div class="search-tabBox"><ul class="search-tab">
						<li class="element-search selected">景区背景</li>
					</div>
					<div class="search element">
						<input type="text" id="scenicspot_bg" name="scenicspot_bg" class="input-text fl" data-index="5" value="" placeholder="">
						<div class="search-btnTab">
							<a href="#" class="search-but element" rel="nofollow" data-index="5" id="btn-search" >
							<input type="file" name="files" id="files" conchange="document.getElementById('scenicspot_bg').value=this.value;" id="image" />上传背景
							</a>
					</div>
					</div>
				</div>	
				<div class="clearfix" style="padding: 0px 0 10px;">
					<div class="search-tabBox"><ul class="search-tab">
						<li class="element-search selected">景区语音</li>
					</div>
					<div class="search element">
						<input type="text" id="scenicspot_wav" id="scenicspot_wav"  class="input-text fl" data-index="5" value="" placeholder="">
						<div class="search-btnTab">
						<a href="#" class="search-but element" rel="nofollow" data-index="5" id="btn-search" >
							<input type="file" name="files" id="files" onpropertychange="alert('');document.getElementById('scenicspot_name').value=this.value;" conchange="alert('');document.getElementById('scenicspot_name').value=this.value;" />上传语音
						</a>
					</div>
					</div>
				</div>	
			</div>
		</div>
	
		<div class="head-top-nav">
			<div class="w1200 clearfix">
				<div class="login-wrap fr">
					<ul class="clearfix" >
						<li class="fl"><input type="submit" name="b1" value="提交" /></li>
					</ul>
				</div>
			</div>
		</div>
	</form>




		<div class="web-bottom">
			<div class="bottom-con w1200 clearfix"><p>西藏景区二维码制作系统<a href="" target="_blank">Copyright © 2017 西藏景优</a> 
			</div>
		</div>

<script type="text/javascript">
			$(window).load(function() {
				$("img.lazy").lazyload({
					effect: "fadeIn",
					threshold : 300,
					failurelimit:10
				});
			});
		</script><script type="text/javascript">        
		var element_num = "5,058,934";
        var yday_up_element = "4,649";
        var back_num = "1,940,722";
        var yday_up_back = "1,346";
        var templet_num = "7,490,805";
        var yday_up_templet = "10,467";
    </script><script type="text/javascript" src="http://js.588ku.com/comp/public/js/public.js?545"></script>
	<script type="text/javascript" src="http://js.588ku.com/comp/index/js/indexV2.js?545"></script>
	<script type="text/javascript" src="http://js.588ku.com/comp/video_listen/js/ku-video.min.js?v=545"></script>
	<script type="text/javascript" src="http://js.588ku.com/comp/index/js/video-config.js"></script>
	<script type="text/javascript">        


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
