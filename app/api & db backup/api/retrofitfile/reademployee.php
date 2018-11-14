<?php

require 'connection.php';

$sql = "SELECT * FROM employee";

$result = mysqli_query($con,$sql);

$response = array();

while ($row = mysqli_fetch_array($result)) {
    
    array_push($response,array('name'=>$row['name'],'designation'=>$row['designation'],'photo'=>$row['photo']));
}
echo json_encode($response);

mysqli_close($con);


?>