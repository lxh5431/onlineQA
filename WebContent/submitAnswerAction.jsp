﻿<%@page import="service.impl.ReplayServiceImpl"%>
<%@page import="service.ReplayService"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="util.*"%>
<%
response.setCharacterEncoding("UTF-8");
request.setCharacterEncoding("UTF-8");
ReplayService replayService=new ReplayServiceImpl();
String errMsg="";
String replayCode = "anonymous";//匿名
String replayIp = Func.getIpAddr(request);
System.out.println("replayIp "+replayIp);
String id = request.getParameter("oid");//主题Id
int oid = Integer.parseInt(id);
request.setAttribute("oid",oid);
%>
<%
if(replayService.exit(oid,replayIp,replayCode))
{
	request.setAttribute("errMsg",errMsg);
	response.sendRedirect("voteFail.jsp");
}
else
{
	response.sendRedirect("voteSuccess.jsp");
}
%>
