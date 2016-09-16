<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme();
request.getServerName();
request.getServerPort();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>



    <base href="<%=basePath%>">
    
    <title>管理员登陆</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script>
    
	function OK_onClick() {
		if (chkForm()) {
			document.all("logform").submit();
			return;
		}
	}

	function chkForm() {
		var chkName = document.all("username").value;
		var chkPassword = document.all("password").value;

		if (chkName == "" || chkName.length == 0) {
			alert("请输入用户名。");
			document.all("username").focus();
			return false;
		} else if (chkPassword == "" || chkPassword.length == 0) {
			alert("请输入密码。");
			document.all("password").focus();
			return false;
		}
		return true;
	}

	//通过点击回车键提交表单
	function entersubmit(e) {
		var charCode = (navigator.appName == "Netscape") ? e.which : e.keyCode;
		if (charCode == 13) {
			OK_onClick();
		}
	}

	//重置
	function resetForm() {
		document.all("logform").reset();
		return;
	}
</script>

</head>

<body  background="image/bg.jpg">
    <div align="center"> <font size=" 2" color="#FF6633"></font>
</div>
<form id="form1" name="form1" method="post" action="LoginServlet">
<table width="357" border="0" align="center">
    <tr>
      <td width="128">用户名：</td>
      <td width="219"><label>
        <input name="username" type="text" id="username" />
      </label></td>
    </tr>
    <tr>
      <td>密　码：</td>
      <td><label>
        <input name="password" type="password" id="password" />
      </label></td>
    </tr>
    <tr>
      <td>
      <label>
        <input type="submit" name="Submit" value="登录" align="right" name=btnLogin onclick="javascript:OK_onClick()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         
        </label>
      </td>
    </tr>
</table>
<p>&nbsp;</p>
</form>
</body>
</html>