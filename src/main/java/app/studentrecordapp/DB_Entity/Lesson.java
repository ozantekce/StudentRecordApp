package app.studentrecordapp.DB_Entity;


import app.studentrecordapp.Enums.Branch;
import app.studentrecordapp.Enums.Semester;
import app.studentrecordapp.Enums.Year;

public class Lesson {

    private String LessonID;
    private String LessonBranchName;
    private String LessonYear;
    private String Semester;


    public Lesson(String lessonID, String lessonBranchName, String lessonYear, String semester) {
        LessonID = lessonID;
        LessonBranchName = lessonBranchName;
        LessonYear = lessonYear;
        Semester = semester;
    }

    public Lesson() {
    }

    public String getLessonID() {
        return LessonID;
    }

    public void setLessonID(String lessonID) {
        LessonID = lessonID;
    }

    public String getLessonBranchName() {
        return LessonBranchName;
    }

    public void setLessonBranchName(String lessonBranchName) {
        LessonBranchName = lessonBranchName;
    }

    public String getLessonYear() {
        return LessonYear;
    }

    public void setLessonYear(String lessonYear) {
        LessonYear = lessonYear;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }
}
