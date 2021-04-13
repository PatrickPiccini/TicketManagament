<%@page import="com.sun.jdi.Type"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.massa.servlet.Servlet" %>
<%@page import="com.massa.dbutilities.BDManip" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="home.css">
<title>Insert title here</title>
</head>
<body>
    <input type="checkbox" class='checkMenu' id="menu">
    <label for="menu" class='icone'>
        <div class='circle'></div>
            <div class="buttonMenu">
                <img src="Background/IconMenu.png" alt="IconMenu">
            </div>
        </div>
    </label>
    <nav class='retangleMenu'>
        </label>
        <ul class='UlMenu'>
            <h2 class='title'>Ticket Management</h2>
            <li class='intesMenu'><a href="" class='blocksLinks'>HOME</a></li>
            <li class='intesMenu'><a href="" class='blocksLinks'>CREATE TICKETS</a></li>
            <li class='intesMenu'><a href="" class='blocksLinks'>MY TICKETS</a></li>
            <li class='intesMenu'><a href="" class='blocksLinks'>SETINGS</a></li>
            <li class='intesMenu'><a href="" class='blocksLinks'>ALGUMACOISA</a></li>
        </ul>
    </nav>
    <header class='cabecalho'>
        <div class='infoHeadrer'>
            <img src="Background/icon.png"  alt="">
            <h2 id='wlc'>Bem Vindo!</h2>
        </div>
    </header>
    <main class='infosMain'>
        <div class='centralinfos'> 
            <input type="text" name="idTecnico" id="idTecnico">
                    <p>
		<%
		 	ArrayList<Object> c = BDManip.viewTickets(1);
    		
    		ArrayList<Object> b = (ArrayList<Object>)c.get(1);
			out.print(b.get(1));
    		
		%>
		</p>
		<p>
		teste de informação
		</p>
        </div>

		

    </main>

</body>
<script src='./joao.js'></script>
</html>