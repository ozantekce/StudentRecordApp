package app.studentrecordapp.DB_Entity;

public class Class_ {

    public String ClassID;
    public String ClassYear;
    public String ClassLetter;

    public Class_(String ClassID, String ClassYear, String ClassLetter) {
        this.ClassID = ClassID;
        this.ClassYear = ClassYear;
        this.ClassLetter = ClassLetter;
    }

    @Override
    public String toString() {
        return ClassYear.toString()+"-"+ ClassLetter;
    }

    public String getClassID() {
        return ClassID;
    }

    public String getClassYear() {
        return ClassYear;
    }

    public String getClassLetter() {
        return ClassLetter;
    }

}
