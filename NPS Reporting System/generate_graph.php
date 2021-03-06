<?php
//Import JPgraph into script.
require_once ('src/jpgraph.php');
require_once ('src/jpgraph_bar.php');
//declare variables
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "NPS";

$ManagersTeam = 'Eight-Bitt';
$teamMembers = array();

//connect to databse & query the results.
$conn = new mysqli($servername, $username, $password, $dbname);
//results = new variable based on who is the manager
$SQL = "SELECT Agent_Name FROM `$ManagersTeam`";
$i = 0;
$result = $conn->query($SQL);
if ($result->num_rows>0) {
    while($row = $result->fetch_assoc()) {

       $teamMembers[$i] = $row['Agent_Name'];
       $i++;

    }
}

//Basic theroy on how to add Arrays of results to draw graph depending on size of team
/*
for ($i=0; $i < sizeof($teamMembers); $i++) {
    if (sizeOf($teamMembers == 8)) {
        $data1y=array($agent[0],$agent[1],$agent[2],$agent[3],$agent[3],$agent[4],$agent[5],$agent[6],$agent[7]);
        $graph->xaxis->setTickLabel($teamMembers[0],$teamMembers[1],$teamMembers[2],$teamMembers[3],$teamMembers[4],$teamMembers[5],$teamMembers[6],$teamMembers[7]);
}
else if (sizeof($teamMembers == 9)){
    $data1y=array($agent[0],$agent[1],$agent[2],$agent[3],$agent[3],$agent[4],$agent[5],$agent[6],$agent[7],$agent[8]);
        $graph->xaxis->setTickLabel($teamMembers[0],$teamMembers[1],$teamMembers[2],$teamMembers[3],$teamMembers[4],$teamMembers[5],$teamMembers[6],$teamMembers[7],$teamMembers[8]);
}
}
*/

//function for calculating NPS scores for each agent
function getNPS($agentName) {
    $servername = "localhost";
$username = "root";
$password = "";
$dbname = "NPS";
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} else {

}
//query databse for all results linked to the Agent
$sql = "SELECT NPS FROM results WHERE Agent='$agentName'";
$result = $conn->query($sql);
//initialise variables for calculating scores
$number = 0;
$promoter = 0;
$detractor = 0;
$passive = 0;
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        if($row['NPS'] >= 9){
        $promoter++;
}
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
} else {

}
//calculate total surveys
$totalSurveys = ($promoter + $passive + $detractor);
$npsScore = ($promoter/ $totalSurveys) * 100;
$npsScore = ceil($npsScore);
//return value of the score.
return $npsScore;
$conn->close();
}

//initialise & populate array - need a dynamic way due to change in size of team
$agent = array();
$agent[0] = getNPS($teamMembers[0]);
$agent[1] = getNPS($teamMembers[1]);
$agent[2] = getNPS($teamMembers[2]);
$agent[3] = getNPS($teamMembers[3]);
$agent[4]  = getNPS($teamMembers[4]);
$agent[5] = getNPS($teamMembers[5]);


//initialise data for that will be graphed
$datay=array($agent[0],$agent[1],$agent[2],$agent[3],$agent[4],$agent[5]);
  $teams=array($teamMembers[0],$teamMembers[1],$teamMembers[2],$teamMembers[3],$teamMembers[4],$teamMembers[5]);

// Create the graph. These two calls are always required
$graph = new Graph(600,300);
$graph->SetScale('textlin');

// Add a drop shadow
$graph->SetShadow();

// Adjust the margin a bit to make more room for titles
$graph->SetMargin(40,30,20,40);
$graph->yaxis->SetTickPositions(array(0,10,20,30,40,50,60,70,80,90,100), array(5,15,25,35,45,55,65,75,85,95));
$graph->xaxis->SetTickLabels($teams);


// Create a bar pot
$bplot = new BarPlot($datay);

// Adjust fill color
$bplot->SetFillColor('orange');
$graph->Add($bplot);

// Setup the titles
$graph->title->Set($ManagersTeam);
$graph->xaxis->title->Set('Agents');
$graph->yaxis->title->Set('NPS %');

$graph->title->SetFont(FF_FONT1,FS_BOLD);
$graph->yaxis->title->SetFont(FF_FONT1,FS_BOLD);
$graph->xaxis->title->SetFont(FF_FONT1,FS_BOLD);

// Display the graph in cache 
//to use graph image wrap in <img> tag
$graph->Stroke();

?>
