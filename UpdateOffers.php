<?php 
require('connection.php');
$Mname =$_GET['Mname'];
$Mlength =$_GET['Mlength'];
$Price =$_GET['Price'];


$makeQuery = "UPDATE membership SET Mlength= '$Mlength', Price='$Price' WHERE Mname= '$Mname'" ;
$stamement =$connection->prepare($makeQuery);
$stamement->execute();


       

?>