package app.studentrecordapp.Database;

import app.studentrecordapp.DB_Entity.Class_;
import app.studentrecordapp.DB_Entity.Lesson;
import app.studentrecordapp.DB_Entity.Student;
import app.studentrecordapp.DB_Entity.Teacher;
import app.studentrecordapp.StudentPageController;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SendRequest {

    public static String uri = "";

    public static void GetStudents() throws Exception {
        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "GetStudents"));

        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);

        JsonParser jsonParser = new JsonParser();

        Object obj = jsonParser.parse(responseString);
        JsonArray list = (JsonArray)obj;

        JsonObject jsonObject = (JsonObject) list.get(0);


        StudentPageController.instance.listOfStudents.clear();
        for (int i = 0; i < list.size(); i++) {
            jsonObject = (JsonObject) list.get(i);
            StudentPageController.instance.addStudent(
                    jsonObject.get("StudentID").getAsString(),
                    jsonObject.get("StudentName").getAsString(),
                    jsonObject.get("StudentSurname").getAsString(),
                    jsonObject.get("StudentEmail").getAsString(),
                    jsonObject.get("StudentPhone").getAsString(),
                    jsonObject.get("StudentDoB").getAsString(),
                    jsonObject.get("Sex").getAsString(),
                    jsonObject.get("GuardianName").getAsString(),
                    jsonObject.get("GuardianSurname").getAsString(),
                    jsonObject.get("GuardianPhone").getAsString(),
                    jsonObject.get("Class").getAsString()
            );
        }



    }

    public static void GetTeachers() throws Exception {
        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "GetTeachers"));

        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);

        JsonParser jsonParser = new JsonParser();

        Object obj = jsonParser.parse(responseString);
        JsonArray list = (JsonArray)obj;

        JsonObject jsonObject = (JsonObject) list.get(0);


        StudentPageController.instance.listOfTeachers.clear();
        for (int i = 0; i < list.size(); i++) {
            jsonObject = (JsonObject) list.get(i);
            StudentPageController.instance.addTeacher(
                    jsonObject.get("TeacherID").getAsString(),
                    jsonObject.get("TeacherName").getAsString(),
                    jsonObject.get("TeacherSurname").getAsString(),
                    jsonObject.get("TeacherEmail").getAsString(),
                    jsonObject.get("TeacherPhone").getAsString(),
                    jsonObject.get("TeacherDoB").getAsString(),
                    jsonObject.get("TeacherSex").getAsString(),
                    jsonObject.get("LessonBranchName").getAsString()
            );
        }



    }

    public static void GetClasses() throws Exception {
        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "GetClasses"));

        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);

        JsonParser jsonParser = new JsonParser();

        Object obj = jsonParser.parse(responseString);
        JsonArray list = (JsonArray)obj;

        JsonObject jsonObject = (JsonObject) list.get(0);


        StudentPageController.instance.listOfClasses.clear();
        for (int i = 0; i < list.size(); i++) {
            jsonObject = (JsonObject) list.get(i);
            StudentPageController.instance.addClass_(
                    jsonObject.get("ClassID").getAsString(),
                    jsonObject.get("ClassYear").getAsString(),
                    jsonObject.get("ClassLetter").getAsString()
            );
        }



    }

    public static void GetLessons() throws Exception{
        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "GetLessons"));

        request.setEntity(new UrlEncodedFormEntity(pairs));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);

        JsonParser jsonParser = new JsonParser();

        Object obj = jsonParser.parse(responseString);
        JsonArray list = (JsonArray)obj;

        JsonObject jsonObject = (JsonObject) list.get(0);

        StudentPageController.instance.listOfLessons.clear();
        for (int i = 0; i < list.size(); i++) {
            jsonObject = (JsonObject) list.get(i);
            StudentPageController.instance.addLesson(
                    jsonObject.get("LessonID").getAsString(),
                    jsonObject.get("LessonBranchName").getAsString(),
                    jsonObject.get("LessonYear").getAsString(),
                    jsonObject.get("Semester").getAsString()
            );
        }


    }


    public static void AddStudent(Student student) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "AddStudent"));

        pairs.add(new BasicNameValuePair("StudentID", addQuotes(student.StudentID())));
        pairs.add(new BasicNameValuePair("StudentName", addQuotes(student.getStudentName())));
        pairs.add(new BasicNameValuePair("StudentSurname", addQuotes(student.getStudentSurname())));
        pairs.add(new BasicNameValuePair("StudentEmail", addQuotes(student.getStudentEmail())));
        pairs.add(new BasicNameValuePair("StudentPhone", addQuotes(student.getStudentPhone())));
        pairs.add(new BasicNameValuePair("StudentDoB", addQuotes(student.getStudentDoB())));
        pairs.add(new BasicNameValuePair("StudentSex", addQuotes(student.getStudentSex())));
        pairs.add(new BasicNameValuePair("GuardianName", addQuotes(student.getGuardianName())));
        pairs.add(new BasicNameValuePair("GuardianSurname", addQuotes(student.getGuardianSurname())));
        pairs.add(new BasicNameValuePair("GuardianPhone", addQuotes(student.getGuardianPhone())));
        pairs.add(new BasicNameValuePair("StudentClassYear", addQuotes(student.getStudentClass().split("-")[0])));
        pairs.add(new BasicNameValuePair("StudentClassLetter", addQuotes(student.getStudentClass().split("-")[1])));


        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        System.out.println(responseString);



    }

    public static void AddTeacher(Teacher teacher) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "AddTeacher"));

        pairs.add(new BasicNameValuePair("TeacherID", addQuotes(teacher.getTeacherID())));
        pairs.add(new BasicNameValuePair("TeacherName", addQuotes(teacher.getTeacherName())));
        pairs.add(new BasicNameValuePair("TeacherSurname", addQuotes(teacher.getTeacherSurname())));
        pairs.add(new BasicNameValuePair("TeacherEmail", addQuotes(teacher.getTeacherEmail())));
        pairs.add(new BasicNameValuePair("TeacherPhone", addQuotes(teacher.getTeacherPhone())));
        pairs.add(new BasicNameValuePair("TeacherDoB", addQuotes(teacher.getTeacherDoB())));
        pairs.add(new BasicNameValuePair("TeacherSex", addQuotes(teacher.getTeacherSex())));
        pairs.add(new BasicNameValuePair("TeacherBranchName", addQuotes(teacher.getTeacherBranchName())));

        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);



    }

    public static void AddClass(Class_ class_) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "AddClass"));

        pairs.add(new BasicNameValuePair("ClassID", addQuotes(class_.getClassID())));
        pairs.add(new BasicNameValuePair("ClassYear", addQuotes(class_.getClassYear())));
        pairs.add(new BasicNameValuePair("ClassLetter", addQuotes(class_.getClassLetter())));


        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);

    }

    public static void AddLesson(Lesson lesson) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "AddLesson"));

        pairs.add(new BasicNameValuePair("LessonID", addQuotes(lesson.getLessonID())));
        pairs.add(new BasicNameValuePair("LessonBranchName", addQuotes(lesson.getLessonBranchName())));
        pairs.add(new BasicNameValuePair("LessonYear", addQuotes(lesson.getLessonYear())));
        pairs.add(new BasicNameValuePair("Semester", addQuotes(lesson.getSemester())));

        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);

    }



    public static void RemoveStudent(Student student) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "RemoveStudent"));

        pairs.add(new BasicNameValuePair("StudentID", addQuotes(student.StudentID())));
        pairs.add(new BasicNameValuePair("StudentName", addQuotes(student.getStudentName())));
        pairs.add(new BasicNameValuePair("StudentSurname", addQuotes(student.getStudentSurname())));
        pairs.add(new BasicNameValuePair("StudentEmail", addQuotes(student.getStudentEmail())));
        pairs.add(new BasicNameValuePair("StudentPhone", addQuotes(student.getStudentPhone())));
        pairs.add(new BasicNameValuePair("StudentDoB", addQuotes(student.getStudentDoB())));
        pairs.add(new BasicNameValuePair("StudentSex", addQuotes(student.getStudentSex())));
        pairs.add(new BasicNameValuePair("GuardianName", addQuotes(student.getGuardianName())));
        pairs.add(new BasicNameValuePair("GuardianSurname", addQuotes(student.getGuardianSurname())));
        pairs.add(new BasicNameValuePair("GuardianPhone", addQuotes(student.getGuardianPhone())));
        pairs.add(new BasicNameValuePair("StudentClassYear", addQuotes(student.getStudentClass().split("-")[0])));
        pairs.add(new BasicNameValuePair("StudentClassLetter", addQuotes(student.getStudentClass().split("-")[1])));


        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);



    }


    public static void RemoveTeacher(Teacher teacher) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "RemoveTeacher"));

        pairs.add(new BasicNameValuePair("TeacherID", addQuotes(teacher.getTeacherID())));
        pairs.add(new BasicNameValuePair("TeacherName", addQuotes(teacher.getTeacherName())));
        pairs.add(new BasicNameValuePair("TeacherSurname", addQuotes(teacher.getTeacherSurname())));
        pairs.add(new BasicNameValuePair("TeacherEmail", addQuotes(teacher.getTeacherEmail())));
        pairs.add(new BasicNameValuePair("TeacherPhone", addQuotes(teacher.getTeacherPhone())));
        pairs.add(new BasicNameValuePair("TeacherDoB", addQuotes(teacher.getTeacherDoB())));
        pairs.add(new BasicNameValuePair("TeacherSex", addQuotes(teacher.getTeacherSex())));
        pairs.add(new BasicNameValuePair("TeacherBranchName", addQuotes(teacher.getTeacherBranchName())));

        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);



    }

    public static void RemoveClass(Class_ class_) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "RemoveClass"));

        pairs.add(new BasicNameValuePair("ClassID", addQuotes(class_.getClassID())));
        pairs.add(new BasicNameValuePair("ClassYear", addQuotes(class_.getClassYear())));
        pairs.add(new BasicNameValuePair("ClassLetter", addQuotes(class_.getClassLetter())));


        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);

    }

    public static void RemoveLesson(Lesson lesson) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "RemoveLesson"));

        pairs.add(new BasicNameValuePair("LessonID", addQuotes(lesson.getLessonID())));
        pairs.add(new BasicNameValuePair("LessonBranchName", addQuotes(lesson.getLessonBranchName())));
        pairs.add(new BasicNameValuePair("LessonYear", addQuotes(lesson.getLessonYear())));
        pairs.add(new BasicNameValuePair("Semester", addQuotes(lesson.getSemester())));

        request.setEntity(new UrlEncodedFormEntity(pairs));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);

    }



    public static void EditStudent(Student student) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "EditStudent"));

        pairs.add(new BasicNameValuePair("StudentID", addQuotes(student.StudentID())));
        pairs.add(new BasicNameValuePair("StudentName", addQuotes(student.getStudentName())));
        pairs.add(new BasicNameValuePair("StudentSurname", addQuotes(student.getStudentSurname())));
        pairs.add(new BasicNameValuePair("StudentEmail", addQuotes(student.getStudentEmail())));
        pairs.add(new BasicNameValuePair("StudentPhone", addQuotes(student.getStudentPhone())));
        pairs.add(new BasicNameValuePair("StudentDoB", addQuotes(student.getStudentDoB())));
        pairs.add(new BasicNameValuePair("StudentSex", addQuotes(student.getStudentSex())));
        pairs.add(new BasicNameValuePair("GuardianName", addQuotes(student.getGuardianName())));
        pairs.add(new BasicNameValuePair("GuardianSurname", addQuotes(student.getGuardianSurname())));
        pairs.add(new BasicNameValuePair("GuardianPhone", addQuotes(student.getGuardianPhone())));
        pairs.add(new BasicNameValuePair("StudentClassYear", addQuotes(student.getStudentClass().split("-")[0])));
        pairs.add(new BasicNameValuePair("StudentClassLetter", addQuotes(student.getStudentClass().split("-")[1])));


        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);



    }

    public static void EditTeacher(Teacher teacher) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "EditTeacher"));

        pairs.add(new BasicNameValuePair("TeacherID", addQuotes(teacher.getTeacherID())));
        pairs.add(new BasicNameValuePair("TeacherName", addQuotes(teacher.getTeacherName())));
        pairs.add(new BasicNameValuePair("TeacherSurname", addQuotes(teacher.getTeacherSurname())));
        pairs.add(new BasicNameValuePair("TeacherEmail", addQuotes(teacher.getTeacherEmail())));
        pairs.add(new BasicNameValuePair("TeacherPhone", addQuotes(teacher.getTeacherPhone())));
        pairs.add(new BasicNameValuePair("TeacherDoB", addQuotes(teacher.getTeacherDoB())));
        pairs.add(new BasicNameValuePair("TeacherSex", addQuotes(teacher.getTeacherSex())));
        pairs.add(new BasicNameValuePair("TeacherBranchName", addQuotes(teacher.getTeacherBranchName())));

        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);



    }

    public static void EditClass(Class_ class_) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "EditClass"));

        pairs.add(new BasicNameValuePair("ClassID", addQuotes(class_.getClassID())));
        pairs.add(new BasicNameValuePair("ClassYear", addQuotes(class_.getClassYear())));
        pairs.add(new BasicNameValuePair("ClassLetter", addQuotes(class_.getClassLetter())));


        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);

    }

    public static void EditLesson(Lesson lesson) throws IOException {

        HttpClient client= new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("requestName", "EditLesson"));

        pairs.add(new BasicNameValuePair("LessonID", addQuotes(lesson.getLessonID())));
        pairs.add(new BasicNameValuePair("LessonBranchName", addQuotes(lesson.getLessonBranchName())));
        pairs.add(new BasicNameValuePair("LessonYear", addQuotes(lesson.getLessonYear())));
        pairs.add(new BasicNameValuePair("Semester", addQuotes(lesson.getSemester())));

        request.setEntity(new UrlEncodedFormEntity(pairs ));
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        //System.out.println(responseString);

    }



    public static String addQuotes(String string){
        return "'"+string+"'";
    }

}


