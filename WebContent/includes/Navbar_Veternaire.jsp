<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head><title>Veterino'&</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">

</head><body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-wide w3-padding w3-card">
  
    <a href="#home" class="w3-bar-item w3-button"><b>MR</b> VETERINO'&</a>
    <!-- Float links to the right. Hide them on small screens -->
    
    <div class="w3-right w1-hide-small">
    <a href="#" class="w3-bar-item w3-button">Bonjour <b>DR ${Session_ADMIN.getLastName()} </b></a>
      <a href="#RDV" class="w3-bar-item w3-button">Gestion RDV</a>
      <a href="#QR" class="w3-bar-item w3-button">Q/R</a>
      <a href="deconnecter" class="w3-bar-item w3-button">Déconnecter</a>
    </div>
  </div>
</div>