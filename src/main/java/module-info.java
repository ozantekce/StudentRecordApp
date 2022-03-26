module app.studentrecordapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;
    requires java.sql;

    opens app.studentrecordapp to javafx.fxml;
    exports app.studentrecordapp;
}