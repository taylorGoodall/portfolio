<head>
  <title>Upload Results</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<?php

require_once 'Classes/PHPExcel.php';

$inputFileName = './Import_data.xlsx';
$colForTitle = 'A';
$colForAuthor = 'B';
$colForState = 'C';
$colForNPS = 'D';
$colForDate = 'E';
$books = array();

$objReader = PHPExcel_IOFactory::createReader('Excel2007');
$objReader->setReadDataOnly(true);
$objPHPExcel = $objReader->load($inputFileName);
$objWorksheet = $objPHPExcel->getActiveSheet();
$highestRow = $objWorksheet->getHighestRow();
$customerID = array();
$team = array();
$NPS = array();
 $Agent = array();

 $servername = "localhost";
$username = "root";
$password = "";
$dbname = "NPS";





 $conn = new mysqli($servername, $username, $password,$dbname);
for ($row = 2; $row <= $highestRow; $row++) {

    $customerID[$row] = $objPHPExcel->getActiveSheet()->getCell($colForTitle.$row)->getValue();
    $Agent[$row] = $objPHPExcel->getActiveSheet()->getCell($colForAuthor.$row)->getValue();
    $team[$row] = $objPHPExcel->getActiveSheet()->getCell($colForState.$row)->getValue();
    $NPS[$row] = $objPHPExcel->getActiveSheet()->getCell($colForNPS.$row)->getValue();
       

    $sql = "INSERT INTO results (CustomerID, Agent,Team,NPS,ddate)
VALUES ('$customerID[$row]', '$Agent[$row]', '$team[$row]','$NPS[$row]','02/03/2016')";

if ($conn->query($sql) === TRUE) {

} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}











}
$conn->close();


//use array values to insert into Database with Row

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "NPS";

/*
// Create connection
$conn = new mysqli($servername, $username, $password,$dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO results (CustomerID, Agent,Team,NPS,ddate)
VALUES ('$customerID[11]', '$Agent[11]', '$team[11]','10','02/03/2016')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();


//echo ($customerID[11]);
//echo ($Agent[11]);
//echo ($team[11]);

 */
//include "./pages.php";

class Book{
    private $title;
    private $author;
    private $state;

    public function __construct($title, $author, $state) {
        $this->title = $title;
        $this->author = $author;
        $this->state = $state;
    }

    public function getTitle(){
        return $this->title;
    }

    public function getAuthor(){
        return $this->author;
    }

    public function getState(){
        return $this->state;
    }
}
?>
  <div class="alert alert-success">
    <strong>Success!</strong> Your teams NPS results Have been successfully Uploaded.
  </div>
