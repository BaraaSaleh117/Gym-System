<?php

	
	if($_SERVER['REQUEST_METHOD'] == "POST"){
		// Get data
		$name = isset($_POST['name']) ? $_POST['name'] : "";
		$phone = isset($_POST['phone']) ? $_POST['phone'] : "";
		$DateOfJoining = isset($_POST['DateOfJoining']) ? $_POST['DateOfJoining'] : "";
                $ExpirationDate = isset($_POST['ExpirationDate']) ? $_POST['ExpirationDate'] : "";


		$server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "gymbase";
		$response  = array();
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		
		$sql = "insert into members values (NULL, '" . $name . "', '" . $phone . "','" . $DateOfJoining . "','" . $ExpirationDate . "')";
		if ($conn->query($sql) === TRUE) {
			$response['error'] = false;
			$response['message'] = "member added successfully!";
		} else {
			$response['error'] = true;
			$response['message'] = "Error, " . $conn->error;
			
		}
		echo json_encode($response);

		$conn->close();
	
	}


?>