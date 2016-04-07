

<head>
  <title>Upload Results</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<?php

//PHP Script to Read through and Excel Spredgsheet then insert it into a MYSQL DATABASE. 
//Inlucded with Bootstrap for a Success Banner 
// Author: Taylor Goodall

require_once 'Classes/PHPExcel.php';
//declare variables
$inputFileName = './Import_data.xlsx';
$colForID = 'A';
$colForAgent = 'B';
$colForTeam = 'C';
$colForNPS = 'D';
$colForDate = 'E';

//initialise the excel reader
$objReader = PHPExcel_IOFactory::createReader('Excel2007');
$objReader->setReadDataOnly(true);
$objPHPExcel = $objReader->load($inputFileName);
$objWorksheet = $objPHPExcel->getActiveSheet();
$highestRow = $objWorksheet->getHighestRow();
$customerID = array();
$team = array();
$NPS = array();
$Agent = array();
//declare variables for MYSQL connection
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "NPS";
//connect to databse
 $conn = new mysqli($servername, $username, $password,$dbname);
 //loop through the worksheet and inset the Excel worksheet into an array
for ($row = 2; $row <= $highestRow; $row++) {

    $customerID[$row] = $objPHPExcel->getActiveSheet()->getCell($colForID.$row)->getValue();
    $Agent[$row] = $objPHPExcel->getActiveSheet()->getCell($colForAgent.$row)->getValue();
    $team[$row] = $objPHPExcel->getActiveSheet()->getCell($colForTeam.$row)->getValue();
    $NPS[$row] = $objPHPExcel->getActiveSheet()->getCell($colForNPS.$row)->getValue();
       
//SQL Query for inserting array values into Database
    $sql = "INSERT INTO results (CustomerID, Agent,Team,NPS,ddate)
VALUES ('$customerID[$row]', '$Agent[$row]', '$team[$row]','$NPS[$row]','02/03/2016')";

if ($conn->query($sql) === TRUE) {

} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}


}
$conn->close();
    }
}
?>
//Bootstrap banner to show success of upload to database
  <div class="alert alert-success">
    <strong>Success!</strong> Your teams NPS results Have been successfully Uploaded.
  </div>
