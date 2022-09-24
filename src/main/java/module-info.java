module fr.tomoetek.jfxgalery {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires javafx.web;


    opens fr.tomoetek.jfxgalery.gui to javafx.fxml;
    opens fr.tomoetek.jfxgalery.gui.exemple to javafx.fxml;

    exports fr.tomoetek.jfxgalery;
    exports fr.tomoetek.jfxgalery.tools;

}