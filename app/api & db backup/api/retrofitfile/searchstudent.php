<?php

require 'connection.php';

$type = $_GET['class_level'];

$sql = "SELECT * FROM student WHERE student.class='".$type."'";

$result = mysqli_query($con,$sql);

$response = array();

while ($row = mysqli_fetch_array($result)) {
    
    array_push($response,array('class'=>$row['class'],'name'=>$row['name']));
}
echo json_encode($response);

mysqli_close($con);

?>