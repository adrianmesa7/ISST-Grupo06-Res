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

<div class="textoresucontainer" style="margin-left: 700px; margin-right: 700px;">
			<h2>AÑADIR RESUMEN</h2>
			<form action="FormCreaResumenAdminServlet" method="post">
             <div class="field">
                Título <br>
                <input type="text" id="title" name="title" placeholder="Titulo resumen"/>
                </div>
                <div class="field">
                Autor <br>
                <input type="text" id="name" name="name" placeholder="Nombre y apellidos"/>
                </div>
                <div class="field">
                Miniatura <br>
                <input type="url" id="urlImage" name="urlImage" placeholder="Enlace a la imagen"/>
                </div>
                <div class="field">
                Resumen <br>
                <input type="url" id="urlResumen" name="urlResumen" placeholder="Enlace a resumen"/>
                </div>
                <div class="actions">
                    <button type="submit">Subir resumen</button>
                </div>
               </form>
				</div>

</div>

</body>
</html>