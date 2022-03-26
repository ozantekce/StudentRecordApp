package app.studentrecordapp.DB_Entity;

public class Student {

    public String StudentID;
    public String StudentName;
    public String StudentSurname;
    public String StudentEmail;
    public String StudentPhone;
    public String StudentDoB;
    public String StudentSex;
    public String GuardianName;
    public String GuardianSurname;
    public String GuardianPhone;
    public String StudentClass;

    public Student(){

    }

    public Student(String StudentID, String studentName, String studentSurname, String studentEmail, String studentPhone, String studentDoB, String studentSex, String guardianName, String guardianSurname, String guardianPhone, String aStudentClass) {
        this.StudentID = StudentID;
        StudentName = studentName;
        StudentSurname = studentSurname;
        StudentEmail = studentEmail;
        StudentPhone = studentPhone;
        StudentDoB = studentDoB;
        StudentSex = studentSex;
        GuardianName = guardianName;
        GuardianSurname = guardianSurname;
        GuardianPhone = guardianPhone;
        StudentClass = aStudentClass;
    }

    public String StudentID() {
        return StudentID;
    }

    public void StudentID(String ID) {
        this.StudentID = ID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentSurname() {
        return StudentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        StudentSurname = studentSurname;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return StudentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        StudentPhone = studentPhone;
    }

    public String getStudentDoB() {
        return StudentDoB;
    }

    public void setStudentDoB(String studentDoB) {
        StudentDoB = studentDoB;
    }

    public String getStudentSex() {
        return StudentSex;
    }

    public void setStudentSex(String studentSex) {
        StudentSex = studentSex;
    }

    public String getGuardianName() {
        return GuardianName;
    }

    public void setGuardianName(String guardianName) {
        GuardianName = guardianName;
    }

    public String getGuardianSurname() {
        return GuardianSurname;
    }

    public void setGuardianSurname(String guardianSurname) {
        GuardianSurname = guardianSurname;
    }

    public String getGuardianPhone() {
        return GuardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        GuardianPhone = guardianPhone;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }
}
