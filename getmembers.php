<?php 
require('connection.php');
$makeQuery =" SELECT * FROM members";
$stamement =$connection->prepare($makeQuery);
$stamement->execute();
$myarray=array();

while($resultsForm = $stamement ->fetch()){

    array_push(
        $myarray,array(
            "name" => $resultsForm['name'],
            "phone" => $resultsForm['phone'],
            "DateOfJoining" => $resultsForm['DateOfJoining'],
            "ExpirationDate" => $resultsForm['ExpirationDate'],
        
        )
        
        );
    }
 echo json_encode($myarray);


       
?>