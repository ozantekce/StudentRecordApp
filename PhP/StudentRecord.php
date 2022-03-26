<?php
header("Access-Control-Allow-Origin: *");

 $connect = new mysqli("hostname","username","password","database");
 if($connect -> connect_errno){
    echo "Failed to connect to MySQL:".$connect -> connect_error;
    exit();
 }else{
     //echo "connect \n";
 }
 
 
 
if($_POST['requestName']=="GetStudents" ){

     $query = "SELECT s.StudentID,s.StudentName,s.StudentSurname,s.StudentEmail,s.StudentPhone,
s.StudentDoB,s.Sex,g.GuardianName,g.GuardianSurname,g.GuardianPhone,CONCAT(c.ClassYear,'-',c.ClassLetter) as Class
FROM Student s,Class c,Guardian g 
WHERE (
	
    g.GuardianID = s.GuardianID
	AND
    c.ClassID = s.ClassID
	
)
";
     
     $result = mysqli_query($connect,$query);
     
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
     echo json_encode($emparray);
    
    
 }
 
 
if($_POST['requestName']=="GetClasses" ){

     $query = "SELECT * 
FROM `Class` 
WHERE 1
ORDER BY ClassYear, ClassLetter
";
     
     $result = mysqli_query($connect,$query);
     
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
     echo json_encode($emparray);
    
    
 }
 
 
if($_POST['requestName']=="GetTeachers" ){

     $query = "SELECT `TeacherID`,`TeacherName`,`TeacherSurname`,`TeacherEmail`,`TeacherPhone`,`TeacherDoB`,`TeacherSex`,LessonBranch.LessonBranchName
FROM Teacher,LessonBranch
WHERE(
	
    TeacherBranchID = LessonBranch.LessonBranchID
	
)
";
     
     $result = mysqli_query($connect,$query);
     
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
     echo json_encode($emparray);
    
    
 }


if($_POST['requestName']=="GetLessons" ){

     $query = "SELECT LessonID,lb.LessonBranchName,LessonYear,Semester FROM `Lesson`, LessonBranch lb 
WHERE (
	Lesson.LessonBranchID = lb.LessonBranchID
)
";
     
     $result = mysqli_query($connect,$query);
     
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
     echo json_encode($emparray);
    
    
 }
 
 
 
 
if($_POST['requestName']=="AddStudent"){
     $ID = $_POST['StudentID'];                     
     $name = $_POST['StudentName'];                 
     $surname = $_POST['StudentSurname'];           
     $email = $_POST['StudentEmail'];               
     $phone = $_POST['StudentPhone'];               
     $doB = $_POST['StudentDoB'];                   
     $sex = $_POST['StudentSex'];                   
     $guardianName = $_POST['GuardianName'];        
     $guardianSurname = $_POST['GuardianSurname'];  
     $guardianPhone= $_POST['GuardianPhone'];       
     $classNumber = $_POST['StudentClassYear'];     
     $classLetter = $_POST['StudentClassLetter'];   
    
     $query = "INSERT INTO Guardian (Guardian.GuardianName,Guardian.GuardianSurname,Guardian.GuardianPhone) 
SELECT * FROM (SELECT $guardianName, $guardianSurname, $guardianPhone) AS tmp
WHERE NOT EXISTS (
    SELECT GuardianID FROM Guardian WHERE Guardian.GuardianPhone = $guardianPhone
) LIMIT 1
";
    
    echo $query;
     $result = mysqli_query($connect,$query);
     echo $result;
    
         $query = "INSERT INTO Student (ClassID, StudentName, StudentSurname, StudentEmail, StudentPhone, StudentDoB, Sex, GuardianID)
	select  Class.ClassID, $name, $surname, $email, $phone, $doB, $sex, GuardianID
	from Guardian,Class
	where (
    	Guardian.GuardianPhone = $guardianPhone
        AND
        Class.ClassYear = $classNumber
        AND
        Class.ClassLetter = $classLetter
    )
";

     //echo $query;
     $result = mysqli_query($connect,$query);
     
     echo $result;
     
    
    
 }
 


if($_POST['requestName']=="AddTeacher"){
     $ID = $_POST['TeacherID'];                     
     $name = $_POST['TeacherName'];                 
     $surname = $_POST['TeacherSurname'];           
     $email = $_POST['TeacherEmail'];               
     $phone = $_POST['TeacherPhone'];               
     $doB = $_POST['TeacherDoB'];                   
     $sex = $_POST['TeacherSex'];                   
     $branchName = $_POST['TeacherBranchName'];        
    
    
$query = "INSERT INTO Teacher (TeacherName, TeacherSurname, TeacherEmail, TeacherPhone,TeacherDoB, TeacherSex, TeacherBranchID)
SELECT $name, $surname, $email, $phone, $doB, $sex, lb.LessonBranchID
FROM LessonBranch lb
WHERE(
	lb.LessonBranchName = $branchName
)
";

     //echo $query;
     $result = mysqli_query($connect,$query);
     
     echo $result;
     
    
    
 }
    
 
 
if($_POST['requestName']=="AddClass"){
    
     $ID = $_POST['ClassID'];                     
     $year = $_POST['ClassYear'];                 
     $letter = $_POST['ClassLetter'];           
    
    
$query = "INSERT INTO `Class` (`ClassYear`, `ClassLetter`) 
VALUES ($year, $letter)
";

     //echo $query;
     $result = mysqli_query($connect,$query);
     
     echo $result;
     
 }
 
 
if($_POST['requestName']=="AddLesson"){
    
     $ID = $_POST['LessonID'];                     
     $branchName = $_POST['LessonBranchName'];                 
     $year = $_POST['LessonYear'];           
     $semester = $_POST['Semester'];     
    
$query = "INSERT INTO Lesson (LessonBranchID, LessonYear, Semester) 
SELECT lb.LessonBranchID, $year, $semester FROM LessonBranch lb
WHERE(
	lb.LessonBranchName = $branchName
)
";

     //echo $query;
     $result = mysqli_query($connect,$query);
     
     echo $result;
     
 } 
 
 
 
 
if($_POST['requestName']=="RemoveStudent" ){
    
    
    $ID = $_POST['StudentID'];      
     $query = "DELETE FROM Student WHERE Student.StudentID = $ID ";
     
    $result = mysqli_query($connect,$query);
     
    echo $result;
    
 }
 

if($_POST['requestName']=="RemoveTeacher" ){
    
    
    $ID = $_POST['TeacherID'];      
     $query = "DELETE FROM Teacher WHERE Teacher.TeacherID = $ID ";
     
    $result = mysqli_query($connect,$query);
     
    echo $result;
    
 }
 
if($_POST['requestName']=="RemoveClass" ){
    
    
    $ID = $_POST['ClassID'];      
     $query = "DELETE FROM Class WHERE Class.ClassID = $ID ";
     
    $result = mysqli_query($connect,$query);
     
    echo $result;
    
 }
 
if($_POST['requestName']=="RemoveLesson" ){
    
    
    $ID = $_POST['LessonID'];      
     $query = "DELETE FROM Lesson WHERE Lesson.LessonID = $ID ";
     
    $result = mysqli_query($connect,$query);
     
    echo $result;
    
 }
 
 
 
 
 
if($_POST['requestName']=="EditStudent"){
     $ID = $_POST['StudentID'];                     
     $name = $_POST['StudentName'];                 
     $surname = $_POST['StudentSurname'];           
     $email = $_POST['StudentEmail'];               
     $phone = $_POST['StudentPhone'];               
     $doB = $_POST['StudentDoB'];                   
     $sex = $_POST['StudentSex'];                   
     $guardianName = $_POST['GuardianName'];        
     $guardianSurname = $_POST['GuardianSurname'];  
     $guardianPhone= $_POST['GuardianPhone'];       
     $classNumber = $_POST['StudentClassYear'];     
     $classLetter = $_POST['StudentClassLetter'];   
    
     $query = "INSERT INTO Guardian (Guardian.GuardianName,Guardian.GuardianSurname,Guardian.GuardianPhone) 
SELECT * FROM (SELECT $guardianName, $guardianSurname, $guardianPhone) AS tmp
WHERE NOT EXISTS (
    SELECT GuardianID FROM Guardian WHERE Guardian.GuardianPhone = $guardianPhone
) LIMIT 1
";
    
    echo $query;
     $result = mysqli_query($connect,$query);
     echo $result;
    
         $query = "INSERT INTO Student (StudentID,ClassID, StudentName, StudentSurname, StudentEmail, StudentPhone, StudentDoB, Sex, GuardianID)
	select $ID, Class.ClassID, $name, $surname, $email, $phone, $doB, $sex, GuardianID
	from Guardian,Class
	where (
    	Guardian.GuardianPhone = $guardianPhone
        AND
        Class.ClassYear = $classNumber
        AND
        Class.ClassLetter = $classLetter
    )
";

     //echo $query;
     $result = mysqli_query($connect,$query);
     
     echo $result;
     
    
    
 }
 


if($_POST['requestName']=="EditTeacher"){
     $ID = $_POST['TeacherID'];                     
     $name = $_POST['TeacherName'];                 
     $surname = $_POST['TeacherSurname'];           
     $email = $_POST['TeacherEmail'];               
     $phone = $_POST['TeacherPhone'];               
     $doB = $_POST['TeacherDoB'];                   
     $sex = $_POST['TeacherSex'];                   
     $branchName = $_POST['TeacherBranchName'];        
    
    
$query = "INSERT INTO Teacher (TeacherID,TeacherName, TeacherSurname, TeacherEmail, TeacherPhone,TeacherDoB, TeacherSex, TeacherBranchID)
SELECT $ID, $name, $surname, $email, $phone, $doB, $sex, lb.LessonBranchID
FROM LessonBranch lb
WHERE(
	lb.LessonBranchName = $branchName
)
";

     //echo $query;
     $result = mysqli_query($connect,$query);
     
     echo $result;
     
    
    
 }
    
 
 
if($_POST['requestName']=="EditClass"){
    
     $ID = $_POST['ClassID'];                     
     $year = $_POST['ClassYear'];                 
     $letter = $_POST['ClassLetter'];           
    
    
$query = "INSERT INTO `Class` (ClassID ,`ClassYear`, `ClassLetter`) 
VALUES ($ID, $year, $letter)
";

     //echo $query;
     $result = mysqli_query($connect,$query);
     
     echo $result;
     
 }
 
 
if($_POST['requestName']=="EditLesson"){
    
     $ID = $_POST['LessonID'];                     
     $branchName = $_POST['LessonBranchName'];                 
     $year = $_POST['LessonYear'];           
     $semester = $_POST['Semester'];     
    
$query = "INSERT INTO Lesson (LessonID, LessonBranchID, LessonYear, Semester) 
SELECT $ID, lb.LessonBranchID, $year, $semester FROM LessonBranch lb
WHERE(
	lb.LessonBranchName = $branchName
)
";

     //echo $query;
     $result = mysqli_query($connect,$query);
     
     echo $result;
     
 } 
 
 
 
 
 
?>