module fr.tomoetek.jfxgalery {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires javafx.web;
    requires flexmark.util.ast;
    requires flexmark;
    requires flexmark.util.data;
    requires org.apache.commons.io;


    opens fr.tomoetek.jfxgalery.gui to javafx.fxml;
    opens fr.tomoetek.jfxgalery.gui.exemple to javafx.fxml;
    opens fr.tomoetek.jfxgalery.gui.buttons to javafx.fxml;

    exports fr.tomoetek.jfxgalery;
    exports fr.tomoetek.jfxgalery.tools;

}