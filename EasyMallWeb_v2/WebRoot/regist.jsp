<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>欢迎注册EasyMall</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/regist.css" />
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
	function checkForm(){
		var flag=true;
		//非空验证
		flag=checkNull("username","用户名不能为空")&&flag;
		flag=checkNull("password","密码不能为空")&&flag;
		flag=checkNull("password2","确认密码不能为空")&&flag;
		flag=checkNull("nickname","昵称不能为空")&&flag;
		flag=checkNull("email","邮箱不能为空")&&flag;
		flag=checkNull("valistr","验证码不能为空")&&flag;
		//密码一致性验证
		flag=checkPassword("password","密码与确认密码必须一致")&&flag;
		//邮箱格式验证
		flag=checkEmail("email","邮箱格式不正确")&&flag;
		return flag;
		
	}
	
	function checkNull(name,msg){
		var value = $("input[name="+name+"]").val();
		setMsg(name,"");
		if($.trim(value)==""){
			setMsg(name,msg);
			return false;
		}
		return true;
	}
	
	function checkPassword(name,msg){
		var password1 = $("input[name="+name+"]").val();
		var password2 = $("input[name="+name+"2]").val();
		if(password1!=password2){
			setMsg(name+"2",msg);
			return false;
		}
		return true;
	}
	
	function checkEmail(name,msg){
		var email=$("input[name="+name+"]").val();
		var reg=/^\w+@\w+(\.\w+)+$/;
		//if(!$.trim(email)==""){
			if(!reg.test(email)){
				setMsg(name,msg);
				return false;
			//}
		}
		return true;
	}
	
	function setMsg(name,msg){
		$("input[name="+name+"]").nextAll("span").html(msg).css("color","red");
	} 
	
	function refresh(){
		$("#td1").text("");
	}
	
	$(function(){
		$("input[name='username']").blur(function(){
			refresh();
			if(checkNull("username","用户名不能为空")){
				var username=$(this).val();
				var url="${pageContext.request.contextPath}/CheckUsernameServlet";
				$("#msg_username").load(url,{"username":username},function(text){
					if("exist"==text){
						$("#msg_username").html("<font style='color:red'>用户名已存在</font>")
					}else{
						$("#msg_username").html("<font style='color:green'>用户名可以使用</font>")
					}
				});
			}
		});
				
		$("input[name='password']").blur(function(){
			refresh();
			checkNull("password","密码不能为空");
		});
		$("input[name='password2']").blur(function(){
			refresh();
			checkNull("password2","确认密码不能为空");
		checkPassword("password","密码与确认密码必须一致");
		});
		$("input[name='nickname']").blur(function(){
			refresh();
		    checkNull("nickname","昵称不能为空");
		});
		$("input[name='email']").blur(function(){
			refresh();
		    checkNull("email","邮箱不能为空");
			checkEmail("email","邮箱格式不正确");
		});
		$("input[name='valistr']").blur(function(){
			refresh();
			checkNull("valistr","验证码不能为空");
		});
		$("#img").click(function(){
			var dateStr=new Date().getTime();
			$(this).attr("src","${pageContext.request.contextPath}/VerifyServlet?"+dateStr);
		});
	});

</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/RegistServlet"
		method="POST" onsubmit="return checkForm()">
		<h1>欢迎注册EasyMall</h1>
		<table>
			<tr>
				<td id="td1" class="tds" colspan="2" style="color:red;text-align:center">
					${empty requestScope.msg ? "" : requestScope.msg}
				</td>
			</tr>
			<tr>
				<td class="tds">用户名：</td>
				<td>
					<input type="text" name="username" value="${empty param.username ? '' : param.username}"/>
					<span id="msg_username"></span>
				</td>
			</tr>
			<tr>
				<td class="tds">密码：</td>
				<td>
					<input type="password" name="password" />
					<span></span>
				</td>
			</tr>
			<tr>
				<td class="tds">确认密码：</td>
				<td>
					<input type="password" name="password2" />
					<span></span>
				</td>
			</tr>
			<tr>
				<td class="tds">昵称：</td>
				<td>
					<input type="text" name="nickname" value="${empty param.nickname ? '' : param.nickname}"/>
					<span></span>
				</td>
			</tr>
			<tr>
				<td class="tds">邮箱：</td>
				<td>
					<input type="text" name="email" value="${empty param.email ? '' : param.email}"/>
					<span></span>
				</td>
			</tr>
			<tr>
				<td  class="tds">验证码：</td>
				<td><input type="text" name="valistr" /> 
					<img id="img" src="${pageContext.request.contextPath}/VerifyServlet" width="" height="" alt="" />
					<span></span>
				</td>
			</tr>
			<tr>
				<td class="sub_td" colspan="2" class="tds">
					<input type="submit" value="注册用户" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
