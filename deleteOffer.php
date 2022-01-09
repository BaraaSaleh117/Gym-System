<?php


	
	$Mname = "";
	if(isset($_GET['Mname'])){
		$Mname = $_GET['Mname'];
	}
	if(!empty($Mname)){
		$server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "gymbase";
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		$sql = "DELETE from membership where Mname = '" . $Mname . "'" ;
		
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