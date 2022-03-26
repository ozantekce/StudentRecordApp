package app.studentrecordapp.DB_Entity;


import app.studentrecordapp.Enums.Branch;
import app.studentrecordapp.Enums.Sex;

import java.time.LocalDate;

public class Teacher {

    private String TeacherID;
    private String TeacherName;
    private String TeacherSurname;
    private String TeacherEmail;
    private String TeacherPhone;
    private String TeacherDoB;
    private String TeacherSex;
    private String TeacherBranchName;


    public Teacher(String teacherID, String teacherName, String teacherSurname, String teacherEmail, String teacherPhone, String teacherDoB, String teacherSex, String teacherBranchName) {
        TeacherID = teacherID;
        TeacherName = teacherName;
        TeacherSurname = teacherSurname;
        TeacherEmail = teacherEmail;
        TeacherPhone = teacherPhone;
        TeacherDoB = teacherDoB;
        TeacherSex = teacherSex;
        TeacherBranchName = teacherBranchName;
    }

    public Teacher() {
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getTeacherSurname() {
        return TeacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        TeacherSurname = teacherSurname;
    }

    public String getTeacherEmail() {
        return TeacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        TeacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return TeacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        TeacherPhone = teacherPhone;
    }

    public String getTeacherDoB() {
        return TeacherDoB;
    }

    public void setTeacherDoB(String teacherDoB) {
        TeacherDoB = teacherDoB;
    }

    public String getTeacherSex() {
        return TeacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        TeacherSex = teacherSex;
    }

    public String getTeacherBranchName() {
        return TeacherBranchName;
    }

    public void setTeacherBranchName(String teacherBranchName) {
        TeacherBranchName = teacherBranchName;
    }
}





