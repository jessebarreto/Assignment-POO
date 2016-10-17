<%@page language="java" import="java.math.*" %>
<%@page import="java.util.*" %>>
<html>
	<head>
		<title>
		Data e Hora Atual - (Exemplo de JSP no meu Server)
		</title>
	</head>
	
	<body>
		<p>
		<b>
		DATA e HORA Atual!: 
		</b>
		<%=Math.random() * 100 %>
		<%
		try
		{
			String.valueOf(Calendar.getInstance());
		}
		catch(Exception e)
		{
			
		}
		%>
		</p>
	</body>
</html>