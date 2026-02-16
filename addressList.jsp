<%@page contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id ="adto" scope="request" class="bean.AddressDTO" />
<jsp:useBean id ="msg" scope="request" class="java.lang.String" />
<html>
	<head>
		<title>表示画面</title>
	</head>
<body>
<h2><%= msg %></h2>
<table border="0">
	<tr>
	  <th width="50">番号</th>
	  <th width="150">名前</th>
	  <th width="150">住所</th>
	</tr>
<%
	for(int i =0;i < adto.size();i++){
		AddressBean ab = adto.get(i);
%>
	<tr>
	  <td align="center"><%= ab.getNo() %></td>
	  <td align="center"><%= ab.getName() %></td>
	  <td align="center"><%= ab.getAddress() %></td>
	</tr>
<% } %>
</table><br />
<a href="/dbweb/addresslist.html">戻る</a>
</body>
</html>
