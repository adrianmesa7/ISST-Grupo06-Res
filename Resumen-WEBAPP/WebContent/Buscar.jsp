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


<h1>

<p class="titleResu">Resumen.es</p>
	
	
<%@ include file="FormLogout.jsp"%> 

</h1>

<div id="main">
	
	<div class="busqueda">
		<form action="FormBuscarServlet">
			<input type="text" name="busqueda" placeholder="" style="width:600px">
			<button type="submit">Buscar</button>
		</form>
	</div>

	<c:forEach items="${resumenes}" var="resumeni">
		<div class="resumen">
			<div class="resumen-img">
				<img src="${resumeni.urlImage}" onerror="this.src='files/placeholder.jpg'"/>
			</div>
			<div class="title" style="font-size: 25px;">
				<b>${resumeni.title}</b>
			</div>
			</br>
			<div class="title">
				Por: <i>${resumeni.name}</i>
			</div>
			<div class="actions">                
				<button class="show"><a href="${resumeni.urlResumen}">Abrir resumen</a></button>             
			</div>			
			<c:if test = "${resumeni.urlAudio != 'urldelaudio'}">
				<div class="actions" style="width:195px; height:30px"> 
					<audio controls style="width:195px">
	  					<source src="${resumeni.urlAudio}" type="audio/mpeg">
						Your browser does not support the audio element.
					</audio>
				</div>
			</c:if>	
			<c:if test = "${resumeni.urlAudio == 'urldelaudio'}">
				<div class="actions" style="width:195px;  height:30px""> 
					Audio no disponible para este resumen
				</div>
			</c:if>				
			<div class="actions" style="width:195px; text-align: center;">
				</br>	
				<p style="width: 18.7ch; overflow: hidden; white-space: nowrap; text-align: center;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Valoracion: ${resumeni.puntuacion}</p>
				<form action="FormValorarServlet">
					<input type="hidden" id="title" name="title" value="${resumeni.title}" />
					<input type="hidden" id="name" name="name" value="${resumeni.name}" />
					<input type="number" name="valoracion" placeholder="" min="0" max="5" style="width:70px">
					<button type="submit">Valorar</button>
				</form>
			</div>
		</div>
	</c:forEach> 

</div>

</body>
</html>