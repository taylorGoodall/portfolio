<?php
//define Database Variables 
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "NPS";
//define NPS Score variables 
$promoter = 0;
$detractor = 0;
$passive = 0;
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

//Query Database to retrieve all survey results from the results table 
$sql = "SELECT NPS FROM results";
$result = $conn->query($sql);
//count number of surveys in database
$countSurveys = "SELECT COUNT(*) AS NPS FROM results"; 
$totalSurveys = $conn->query($countSurveys);
//loop through table and grab the surveys and place into Arrays 
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        //echo "" . $row["NPS"].  "<br>";
        //Find out if Promoter 
        if($row["NPS"] >= 9) {
            $promoter++;
}
//Find out of Passive 
else if($row["NPS"] == 7 ){
    $passive++;
}
//Find out if passive 
else if($row["NPS"] == 8 ){
    $passive++;
}
//IF Result is not Promoter || Passive assume it is a detractor 
else {
    $detractor++;
}
}
}
//Count total rows 
$row_cnt = $result->num_rows;
//calculate Percentage of promoters
$npsScore = ($promoter / $row_cnt) * 100;
//Display information about surveys 
echo "NPS Score "; echo (ceil($npsScore));
echo "</br>Number of Surveys in Database $row_cnt</br>";
Echo "Number of promoters $promoter</br>";
echo "Number of Detractors $detractor</br>";
echo "Number of Passives $passive</br";
echo "hehehe";
  //close connection to the databse
$conn->close();

//Graph to calculate variables 










?> 