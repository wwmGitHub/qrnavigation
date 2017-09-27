<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>西藏景区二维码导览制作系统</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.1.12.2.js"></script>
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<script type="text/javascript">
	function login(){
		var form = $('#f');
		var name =  $('#userLoginName').val();
		if(name==""){
			alert('请输入登录名称！');return;
		}
		var pass =  $('#userLoginPass').val();
		if(pass==""){
			alert('请输入登录密码！');return;
		}
		var pwd =  $('#userLoginPass').attr("value");
		if (name!="admin" && pass!="admin"){
			/*景区普通账号*/
			$.post('${pageContext.request.contextPath}/userController/login', form.serialize(), function(result) {
				var ss = JSON.parse(result);
				if(ss.success){
					/*成功登陆之后    即可访问景区信息平台页面 commonuser.jsp*/

					window.location.href = "${pageContext.request.contextPath}/userController/findcommonsuser?userLoginName="+name+"&userLoginPass="+pass+""
				}
			});
		}else {
			/*系统用户*/
			$.post('${pageContext.request.contextPath}/userController/login', form.serialize(), function(result) {
				var ss = JSON.parse(result);
				if(ss.success){

					window.location.href = "${pageContext.request.contextPath}/productController/list?userLoginName="+name+"&userLoginPass="+pass+""
				}
			});
		}

	}
	
	function keydown(){
		if (event.keyCode == 13){
			login();
		}
	}
</script>
</head>

<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h2>西藏景区二维码导览制作系统</h2>
						<form action="#" name="f" id="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="userLoginName" id="userLoginName" onkeydown="keydown()" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="userLoginPass" id="userLoginPass" onkeydown="keydown()" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><a class="act-but submit" href="" onclick="login();return false;" style="color: #FFFFFF">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
		<div style="text-align:center;">
</div>
	</body>
</html>
