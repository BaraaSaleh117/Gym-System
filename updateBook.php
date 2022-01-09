<?php

	
	
		// Get data
                $cat = "";
	       if(isset($_GET['cat'])){
		$cat = $_GET['cat'];
	             }
		$title = isset($_POST['title']) ? $_POST['title'] : "";
		$pages = isset($_POST['pages']) ? $_POST['pages'] : "";
		

		$server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "gymbase";
		$response  = array();
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
                    } 

		
		$sql = "UPDATE books SET title = '" . $title . "',pages= '" . $pages . "' WHERE category = '" . $cat . "'" ;
		if ($conn->query($sql) === TRUE) {
			$response['error'] = false;
			$response['message'] = "book added successfully!";
		} else {
			$response['error'] = true;
			$response['message'] = "Error, " . $conn->error;
			
		}
		echo json_encode($response);

		$conn->close();
	
	


?>