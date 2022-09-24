package fr.tomoetek.jfxgalery.tools;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.web.WebView;

public abstract class FenTool {
    public WebView webView;
    public JFXButton fermeButt;

    public void loadCours(String link){
        webView.getEngine().load(String.format("https://germainsip.github.io/post/cours/java/javafxelmts/#%s", link));

    }
    @FXML
    public void closeHandle(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
