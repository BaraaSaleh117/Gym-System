<?php 
require('connection.php');
$makeQuery =" SELECT * FROM books";
$stamement =$connection->prepare($makeQuery);
$stamement->execute();
$myarray=array();

while($resultsForm = $stamement ->fetch()){

    array_push(
        $myarray,array(
            "title" => $resultsForm['title'],
            "category" => $resultsForm['category'],
            "pages" => $resultsForm['pages'],
        
        )
        
        );
    }
 echo json_encode($myarray);


       
?>