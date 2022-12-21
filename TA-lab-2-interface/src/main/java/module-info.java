module com.university.ta {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.university.ta to javafx.fxml;
    exports com.university.ta;
}