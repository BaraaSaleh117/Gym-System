<?php

	
	if($_SERVER['REQUEST_METHOD'] == "POST"){
		// Get data
		$title = isset($_POST['title']) ? $_POST['title'] : "";
		$cat = isset($_POST['cat']) ? $_POST['cat'] : "";
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
		
		$sql = "insert into books values (NULL, '" . $title . "','" . $cat . "'," . $pages . ")";
		if ($conn->query($sql) === TRUE) {
			$response['error'] = false;
			$response['message'] = "book added successfully!";
		} else {
			$response['error'] = true;
			$response['message'] = "Error, " . $conn->error;
			
		}
		echo json_encode($response);

		$conn->close();
	
	}


?>