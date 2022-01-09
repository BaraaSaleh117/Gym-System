<?php

	
	if($_SERVER['REQUEST_METHOD'] == "POST"){
		
                $Mname = isset($_POST['Mname']) ? $_POST['Mname'] : "";
		$Mlength = isset($_POST['Mlength']) ? $_POST['Mlength'] : "";
		$Price = isset($_POST['Price']) ? $_POST['Price'] : "";
                
              
                $server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "gymbase";
		$response  = array();
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		
		$sql = "insert into membership values (NULL,'" . $Mname . "', '" . $Mlength . "','" . $Price . "')";
		if ($conn->query($sql) === TRUE) {
			$response['error'] = false;
			$response['message'] = "Offer added successfully!";
		} else {
			$response['error'] = true;
			$response['message'] = "Error, " . $conn->error;
			
		}
		echo json_encode($response);

		$conn->close();
	
	}



?>