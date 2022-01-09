<?php 
require('connection.php');
$title =$_GET['title'];
$pages =$_GET['pages'];

$makeQuery = "UPDATE books SET pages= '$pages' WHERE title = '$title'" ;
$stamement =$connection->prepare($makeQuery);
$stamement->execute();


    


       

?>