module fr.tomoetek.jfxgalery {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.tomoetek.jfxgalery.gui to javafx.fxml;
    requires com.jfoenix;
    requires javafx.web;
    exports fr.tomoetek.jfxgalery;
    exports fr.tomoetek.jfxgalery.tools;

}