<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'home.jsp' starting page</title>
  </head>
  
  <body>
  	<h2>${message }</h2>
    hello,SpringMVC!${username }
    <img alt="" src="static/img/git.png">
    <form action="user/upload" method="post" enctype="multipart/form-data">
    	Desc: <input type="text" name="name"/><br/>
    	<input type="file" name="myfile"/><br/>
    	<input type="submit" value="Upload"/>
    </form>
    
  </body>
</html>
