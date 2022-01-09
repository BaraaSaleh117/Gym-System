<?php 
require('connection.php');
$name =$_GET['name'];
$phone =$_GET['phone'];
$DateOfJoining =$_GET['DateOfJoining'];
$ExpirationDate =$_GET['ExpirationDate'];

$makeQuery = "UPDATE members SET phone= '$phone', DateOfJoining='$DateOfJoining',ExpirationDate='$ExpirationDate' WHERE name= '$name'" ;
$stamement =$connection->prepare($makeQuery);
$stamement->execute();



       

?>