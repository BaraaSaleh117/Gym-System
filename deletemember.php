<?php


	
	$name = "";
	if(isset($_GET['name'])){
		$name = $_GET['name'];
	}
	if(!empty($name)){
		$server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "gymbase";
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		$sql = "DELETE from members where name = '" . $name . "'" ;
		
		$result = $conn->query($sql);
		$resultarray = array();
		while($row =mysqli_fetch_assoc($result))
		{
			$resultarray[] = $row;
		}
		echo json_encode($resultarray);
		
		$conn->close();
		
	}
	
	




?>