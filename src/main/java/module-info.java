module com.example.ticketbuyer {
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;


    opens com.example.ticketbuyer to javafx.fxml;
    exports com.example.ticketbuyer;
}