<%@page import="java.net.URLDecoder"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="css/login.css"/>
		<title>EasyMall欢迎您登录</title>
	<script type="text/javascript" src="js/ajax.js"></script>
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script>
		$(function(){
			$("input[name='username']").blur(function(){
				refresh();
				checkNull("username","用户名不能为空");
			});
			$("input[name='password']").blur(function(){
				refresh();
				checkNull("password","密码不能为空");
			});
		});
		
		function checkForm(){
			var flag=true;
			flag=checkNull("username","用户名不能为空")&&flag;
			flag=checkNull("password","密码不能为空")&&flag;
			return flag;
		}
		
		function refresh(){
			$("#td1").text("");
		}
		
		function checkNull(name,msg){
			var value=$("input[name="+name+"]").val();
			setMsg(name,"");
			if($.trim(value)==""){
				setMsg(name,msg);
				return false;
			}
			return true;
		}
		
		function setMsg(name,msg){
			$("input[name="+name+"]").nextAll("span").html(msg).css("color","red");
		}
	</script>
	</head>
	<body>
		<h1>欢迎登录EasyMall</h1>
		<form action="${pageContecontextPath}/LoginServlet" method="POST" onsubmit="return checkForm()">
			<table>
			<% 
				Cookie[] ck=request.getCookies();
				Cookie remnameCookie=null;
				if(ck!=null){
					for(Cookie cookie:ck){
						if("remname".equals(cookie.getName())){
							remnameCookie=cookie;
						}
					}
				}
				String username="";
				if(remnameCookie!=null){
					username=remnameCookie.getValue();
					username=URLDecoder.decode(username, "utf-8");
				}
			%>
			
				<tr>
					<td id="td1" class="tdx" colspan="2" style="color:red;text-align:center">
						${empty requestScope.msg ? "" : requestScope.msg}
					</td>
				</tr>
				<tr>
					<td class="tdx">用户名：</td>
					<td>
						<input type="text" name="username" value="<%=username%>"/>
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tdx">密&nbsp;&nbsp; 码：</td>
					<td>
						<input type="password" name="password"/>
						<span></span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="remname" value="true" <%=username.equals("")?"":"checked='checked'"%>/>记住用户名
						<input type="checkbox" name="autologin" value="true"/>30天内自动登录
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登 录"/>
					</td>
				</tr>
			</table>
		</form>		
	</body>
</html>
