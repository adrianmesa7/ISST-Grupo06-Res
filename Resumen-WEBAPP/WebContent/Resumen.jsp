<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Resumen.es</title>
	<link rel="icon" type="image/png" href="img/logo.png">
	<link href="https://allfont.es/allfont.css?fonts=garamond" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>

<body>


<h1><p class="titleResu">Resumen.es</p>
	
	
<%@ include file="FormLogout.jsp"%> </h1>

<div id="main">

	<c:forEach items="${resumenes}" var="resumeni">
		<div class="resumen">
			<div class="resumen-img">
				<img src="${resumeni.urlImage}" onerror="this.src='files/placeholder.jpg'"/>
			</div>
			<div class="title">
				<b>${resumeni.title}</b>
			</div>
			<div class="title">
				Por: <i>${resumeni.name}</i>
			</div>
			<div class="actions">                
				<button class="show"><a href="${resumeni.urlResumen}">Abrir resumen</a></button>             
			</div>
		</div>
	</c:forEach>

</div>

</body>
</html>