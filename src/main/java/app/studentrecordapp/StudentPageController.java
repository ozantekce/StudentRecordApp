package app.studentrecordapp;

import app.studentrecordapp.Database.SendRequest;
import app.studentrecordapp.DB_Entity.*;
import app.studentrecordapp.Enums.Year;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class StudentPageController {

    public static StudentPageController instance;


    public  ObservableList<Student> listOfStudents;
    public  ObservableList<Teacher> listOfTeachers;
    public  ObservableList<Class_> listOfClasses;
    public  ObservableList<Lesson> listOfLessons;

    public Student addStudent(Student student){
        listOfStudents.add(student);
        return student;
    }


    public Class_ addClass_(Class_ class_){
        listOfClasses.add(class_);
        return class_;
    }

    public Teacher addTeacher(Teacher teacher){
        listOfTeachers.add(teacher);
        return teacher;
    }

    public Lesson addLesson(Lesson lesson){
        listOfLessons.add(lesson);
        return lesson;
    }

    public void addStudent(String studentID, String studentName, String studentSurname,
                                  String studentEmail, String studentPhone, String studentDoB,
                                  String sex, String guardianName, String guardianSurname,
                                  String guardianPhone,String class_) {

        addStudent(new Student(studentID,studentName,studentSurname,studentEmail,studentPhone,studentDoB,sex,guardianName,guardianSurname,guardianPhone,class_));

    }

    public void addClass_(String classID, String classYear, String classLetter) {

        addClass_(new Class_(classID,classYear,classLetter));
        studentClassCB.getItems().clear();
        for (int i = 0; i < listOfClasses.size(); i++) {
            studentClassCB.getItems().add(listOfClasses.get(i).toString());
        }
        if(studentClassCB.getItems()!=null|| studentClassCB.getItems().size()>0)
            studentClassCB.setValue(studentClassCB.getItems().get(0));

    }

    public void addTeacher(String teacherID, String teacherName, String teacherSurname, String teacherEmail, String teacherPhone, String teacherDoB, String teacherSex, String lessonBranchName) {

        addTeacher(new Teacher(teacherID,teacherName,teacherSurname,teacherEmail,teacherPhone,teacherDoB,teacherSex,lessonBranchName));

    }

    public void addLesson(String lessonID, String lessonBranchName, String lessonYear, String semester) {

        addLesson(new Lesson(lessonID,lessonBranchName,lessonYear,semester));

    }


    public void initializeListOfStudents() {
        listOfStudents = FXCollections.observableArrayList();
        studentIDColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().StudentID()));
        studentNameColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getStudentName()));
        studentSurnameColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getStudentSurname()));
        studentEmailColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getStudentEmail()));
        studentPhoneColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getStudentPhone()));
        studentDoBColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getStudentDoB()));
        studentSexColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getStudentSex()));
        guardianNameColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getGuardianName()));
        guardianSurnameColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getStudentSurname()));
        guardianPhoneColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getGuardianPhone()));
        studentClassColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getStudentClass()));
        studentTV.setItems(listOfStudents);
    }


    public void initializeListOfTeachers() {
        listOfTeachers = FXCollections.observableArrayList();
        teacherIDColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTeacherID()));
        teacherNameColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTeacherName()));
        teacherSurnameColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTeacherSurname()));
        teacherEmailColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTeacherEmail()));
        teacherPhoneColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTeacherPhone()));
        teacherDoBColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTeacherDoB()));
        teacherSexColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTeacherSex()));
        teacherBranchColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getTeacherBranchName()));
        teacherTV.setItems(listOfTeachers);

    }

    public void initializeListOfClasses() {
        listOfClasses = FXCollections.observableArrayList();
        classIDColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getClassID()));
        classYearColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getClassYear()));
        classLetterColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getClassLetter()));
        classTV.setItems(listOfClasses);

    }

    public void initializeListOfLessons() {
        listOfLessons = FXCollections.observableArrayList();
        lessonIDColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getLessonID()));
        lessonBranchColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getLessonBranchName()));
        lessonYearColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getLessonYear()));
        lessonSemesterColumn.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getSemester()));
        lessonTV.setItems(listOfLessons);


    }




//region LESSON_FXML
    @FXML
    TableView<Lesson> lessonTV;

    @FXML
    TableColumn<Lesson,String> lessonIDColumn,lessonBranchColumn,lessonYearColumn,lessonSemesterColumn;


    @FXML
    TextField lessonIDTF;
    @FXML
    ComboBox lessonBranchCB;
    @FXML
    ComboBox lessonYearCB;
    @FXML
    ComboBox lessonSemesterCB;
//endregion



//region CLASS_FXML
    @FXML
    TableView<Class_> classTV;

    @FXML
    TableColumn<Class_,String> classIDColumn,classYearColumn,classLetterColumn;


    @FXML
    TextField classIDTF;
    @FXML
    ComboBox<String> classYearCB;
    @FXML
    ComboBox<String> classLetterCB;
//endregion


//region TEACHER_FXML
    @FXML
    TableView<Teacher> teacherTV;

    @FXML
    TableColumn<Teacher,String> teacherIDColumn,teacherNameColumn,teacherSurnameColumn,teacherEmailColumn,teacherPhoneColumn;
    @FXML
    TableColumn<Teacher, String>  teacherDoBColumn;
    @FXML
    TableColumn<Teacher,String>  teacherSexColumn;
    @FXML
    TableColumn<Teacher,String>  teacherBranchColumn;

    @FXML
    TextField teacherIDTF,teacherNameTF,teacherSurnameTF,teacherEmailTF,teacherPhoneTF;
    @FXML
    DatePicker teacherDoBDP;
    @FXML
    ComboBox teacherSexCB;
    @FXML
    ComboBox teacherBranchCB;


    @FXML
    Button teacherAddButton,teacherEditButton,teacherDeleteButton,teacherFindButton;

    @FXML
    Button teacherUpdateTVButton;
//endregion



//region STUDENT_FXML
    @FXML
    TableView<Student> studentTV;

    @FXML
    TableColumn<Student,String> studentIDColumn,studentNameColumn,studentSurnameColumn,studentEmailColumn,studentPhoneColumn;
    @FXML
    TableColumn<Student, String>  studentDoBColumn;
    @FXML
    TableColumn<Student,String>  studentSexColumn;
    @FXML
    TableColumn<Student,String>  guardianNameColumn,guardianSurnameColumn,guardianPhoneColumn;
    @FXML
    TableColumn<Student,String>  studentClassColumn;


    @FXML
    TextField studentIDTF,studentNameTF,studentSurnameTF,studentEmailTF,studentPhoneTF;
    @FXML
    DatePicker studentDoBDP;
    @FXML
    ComboBox<String> studentSexCB;
    @FXML
    TextField guardianNameTF,guardianSurnameTF,guardianPhoneTF;
    @FXML
    ComboBox<String> studentClassCB;


    @FXML
    Button studentAddButton,studentEditButton,studentDeleteButton,studentFindButton;

    @FXML
    Button studentUpdateTVButton;

//endregion


    @FXML
    public void initialize() {

        instance = this;

        initializeListOfStudents();
        initializeListOfTeachers();
        initializeListOfClasses();
        initializeListOfLessons();
        initializeComboBoxes();

        try {
            SendRequest.GetStudents();
            SendRequest.GetLessons();
            SendRequest.GetTeachers();
            SendRequest.GetClasses();
        } catch (Exception e) {
            e.printStackTrace();
        }





    }

    private void initializeComboBoxes() {
        studentSexCB.getItems().addAll(
                "M",
                "F"
        );
        studentSexCB.setValue("M");

        teacherSexCB.getItems().addAll(
                "M",
                "F"
        );
        teacherSexCB.setValue("M");

        teacherBranchCB.getItems().addAll(
                "Maths","Biology","Physics","Chemistry","History"
        );
        teacherBranchCB.setValue("Maths");


        classYearCB.getItems().addAll("1","2","3","4");
        classYearCB.setValue("1");

        classLetterCB.getItems().addAll("A","B","C","D","E");
        classLetterCB.setValue("A");

        lessonBranchCB.getItems().addAll("Maths","Biology","Physics","Chemistry","History");
        lessonBranchCB.setValue("Maths");

        lessonYearCB.getItems().addAll("1","2","3","4");
        lessonYearCB.setValue("1");

        lessonSemesterCB.getItems().addAll("1","2");
        lessonSemesterCB.setValue("1");



    }



    @FXML
    public void onActionStudentUpdateTVButton(){

        try {
            SendRequest.GetStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void onActionClassUpdateTVButton(){

        try {
            SendRequest.GetClasses();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void onActionTeacherUpdateTVButton(){

        try {
            SendRequest.GetTeachers();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void onActionLessonUpdateTVButton(){

        try {
            SendRequest.GetLessons();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




//region Student

    //region Student_Table_Select
    private static Student selectedStudent;

    @FXML
    public void onStudentTVSelect(){

        selectedStudent = studentTV.getSelectionModel().getSelectedItem();

        if(selectedStudent==null)
            return;
                studentIDTF.setText(selectedStudent.StudentID());
                studentNameTF.setText(selectedStudent.getStudentName());
                studentSurnameTF.setText(selectedStudent.getStudentSurname());
                studentEmailTF.setText(selectedStudent.getStudentEmail());
                studentPhoneTF.setText(selectedStudent.getStudentPhone());
                studentDoBDP.setValue(sqlDateToLocalDate(selectedStudent.getStudentDoB()));
                studentSexCB.setValue(selectedStudent.getStudentSex());
                guardianNameTF.setText(selectedStudent.getGuardianName());
                guardianSurnameTF.setText(selectedStudent.getGuardianSurname());
                guardianPhoneTF.setText(selectedStudent.getGuardianPhone());
                studentClassCB.setValue(selectedStudent.getStudentClass());

    }


    //endregion



    //region Student_Button_methods

    @FXML
    public void onActionStudentAddButton(){

        Student student = new Student(
                studentIDTF.getText(),
                studentNameTF.getText(),
                studentSurnameTF.getText(),
                studentEmailTF.getText(),
                studentPhoneTF.getText(),
                localDateToSqlDate(studentDoBDP.getValue()),
                studentSexCB.getValue(),
                guardianNameTF.getText(),
                guardianSurnameTF.getText(),
                guardianPhoneTF.getText(),
                studentClassCB.getValue()
        );

        try {
            SendRequest.AddStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

        onActionStudentUpdateTVButton();

    }

    @FXML
    public void onActionStudentEditButton(){
        try {
            SendRequest.RemoveStudent(selectedStudent);
            SendRequest.EditStudent(new Student(
                    studentIDTF.getText(),
                    studentNameTF.getText(),
                    studentSurnameTF.getText(),
                    studentEmailTF.getText(),
                    studentPhoneTF.getText(),
                    localDateToSqlDate(studentDoBDP.getValue()),
                    studentSexCB.getValue(),
                    guardianNameTF.getText(),
                    guardianSurnameTF.getText(),
                    guardianPhoneTF.getText(),
                    studentClassCB.getValue()
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        onActionStudentUpdateTVButton();
    }

    @FXML
    public void onActionStudentDeleteButton(){
        try {
            SendRequest.RemoveStudent(selectedStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        onActionStudentUpdateTVButton();
    }


    //endregion





//endregion





//region Teacher

    //region Teacher_Table_Select
    private static Teacher selectedTeacher;

    @FXML
    public void onTeacherTVSelect(){

        selectedTeacher = teacherTV.getSelectionModel().getSelectedItem();

        if(selectedTeacher==null)
            return;
        teacherIDTF.setText(selectedTeacher.getTeacherID());
        teacherNameTF.setText(selectedTeacher.getTeacherName());
        teacherSurnameTF.setText(selectedTeacher.getTeacherSurname());
        teacherEmailTF.setText(selectedTeacher.getTeacherEmail());
        teacherPhoneTF.setText(selectedTeacher.getTeacherPhone());
        teacherDoBDP.setValue(sqlDateToLocalDate(selectedTeacher.getTeacherDoB()));
        teacherSexCB.setValue(selectedTeacher.getTeacherSex());
        teacherBranchCB.setValue(selectedTeacher.getTeacherBranchName());

    }

    //endregion



    //region Teacher_Button_methods

    @FXML
    public void onActionTeacherAddButton(){

        Teacher teacher = new Teacher(
                teacherIDTF.getText(),
                teacherNameTF.getText(),
                teacherSurnameTF.getText(),
                teacherEmailTF.getText(),
                teacherPhoneTF.getText(),
                localDateToSqlDate(teacherDoBDP.getValue()),
                teacherSexCB.getValue().toString(),
                teacherBranchCB.getValue().toString()
        );

        try {
            SendRequest.AddTeacher(teacher);
        } catch (IOException e) {
            e.printStackTrace();
        }

        onActionTeacherUpdateTVButton();

    }

    @FXML
    public void onActionTeacherEditButton(){
        try {
            SendRequest.RemoveTeacher(selectedTeacher);
            SendRequest.EditTeacher(new Teacher(
                    teacherIDTF.getText(),
                    teacherNameTF.getText(),
                    teacherSurnameTF.getText(),
                    teacherEmailTF.getText(),
                    teacherPhoneTF.getText(),
                    localDateToSqlDate(teacherDoBDP.getValue()),
                    teacherSexCB.getValue().toString(),
                    teacherBranchCB.getValue().toString()
            ));
        }catch (IOException e){
            e.printStackTrace();
        }
        onActionTeacherUpdateTVButton();

    }

    @FXML
    public void onActionTeacherDeleteButton(){

        try {
            SendRequest.RemoveTeacher(selectedTeacher);
        }catch (Exception e){
            e.printStackTrace();
        }

        onActionTeacherUpdateTVButton();

    }


    //endregion





//endregion





//region Class

    //region Class_Table_Select
    private static Class_ selectedClass;

    @FXML
    public void onClassTVSelect(){

        selectedClass = classTV.getSelectionModel().getSelectedItem();

        if(selectedClass==null)
            return;
        classIDTF.setText(selectedClass.getClassID());
        classYearCB.setValue(selectedClass.getClassYear());
        classLetterCB.setValue(selectedClass.getClassLetter());


    }


    //endregion


    //region Teacher_Button_methods

    @FXML
    public void onActionClassAddButton(){

        Class_ class_ = new Class_(
                classIDTF.getText(),
                classYearCB.getValue(),
                classLetterCB.getValue()
        );

        try {
            SendRequest.AddClass(class_);
        } catch (IOException e) {
            e.printStackTrace();
        }

        onActionClassUpdateTVButton();


    }

    @FXML
    public void onActionClassEditButton(){

        try {
            SendRequest.RemoveClass(selectedClass);
            SendRequest.EditClass(new Class_(
                    classIDTF.getText(),
                    classYearCB.getValue(),
                    classLetterCB.getValue()
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        onActionClassUpdateTVButton();
    }

    @FXML
    public void onActionClassDeleteButton(){
        try {
            SendRequest.RemoveClass(selectedClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        onActionClassUpdateTVButton();
    }


    //endregion

//endregion





//region Lesson

    //region Lesson_Table_Select
    private static Lesson selectedLesson;

    @FXML
    public void onLessonTVSelect(){

        selectedLesson = lessonTV.getSelectionModel().getSelectedItem();

        if(selectedLesson==null)
            return;
        lessonIDTF.setText(selectedLesson.getLessonID());
        lessonBranchCB.setValue(selectedLesson.getLessonBranchName());
        lessonYearCB.setValue(selectedLesson.getLessonYear());
        lessonSemesterCB.setValue(selectedLesson.getSemester());

    }


    //endregion


    //region Lesson_Button_methods

    @FXML
    public void onActionLessonAddButton(){

        Lesson lesson = new Lesson(
                lessonIDTF.getText(),
                lessonBranchCB.getValue().toString(),
                lessonYearCB.getValue().toString(),
                lessonSemesterCB.getValue().toString()
        );

        try {
            SendRequest.AddLesson(lesson);

        } catch (IOException e) {
            e.printStackTrace();
        }

        onActionLessonUpdateTVButton();

    }

    @FXML
    public void onActionLessonEditButton(){


        try {
            SendRequest.RemoveLesson(selectedLesson);
            SendRequest.EditLesson(new Lesson(
                    lessonIDTF.getText(),
                    lessonBranchCB.getValue().toString(),
                    lessonYearCB.getValue().toString(),
                    lessonSemesterCB.getValue().toString()
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        onActionLessonUpdateTVButton();
    }

    @FXML
    public void onActionLessonDeleteButton(){
        try {
            SendRequest.RemoveLesson(selectedLesson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        onActionLessonUpdateTVButton();
    }


    //endregion

//endregion




    public static String localDateToSqlDate(LocalDate localDate){

        java.sql.Date sqlDate;
        try {
            sqlDate = java.sql.Date.valueOf(selectedTeacher.getTeacherDoB());
        }catch (Exception e){
            sqlDate = java.sql.Date.valueOf(LocalDate.now());
        }
        return sqlDate.toString();
    }

    public static LocalDate sqlDateToLocalDate(String sqlDate){


        LocalDate localDate;
        try {
            java.sql.Date sqlDate_ = java.sql.Date.valueOf(sqlDate);
            localDate = sqlDate_.toLocalDate();
        }catch (Exception e){
            localDate = LocalDate.now();
        }
        return localDate;
    }




}