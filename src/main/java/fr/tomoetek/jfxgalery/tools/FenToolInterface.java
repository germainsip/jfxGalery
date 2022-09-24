package fr.tomoetek.jfxgalery.tools;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.web.WebView;

import java.io.IOException;

/**
 * L'interface FenToolInterface est utilisée pour ajouter les fonctionnalités récurrentes de l'application
 */
public interface FenToolInterface {
    WebView webView = new WebView();
    JFXButton fermeButt = new JFXButton();
    String exempleFxml = "";

    default void loadCours(String link){
        webView.getEngine().load(String.format("https://germainsip.github.io/post/cours/java/javafxelmts/#%s", link));

    }

    /**
     * Méthode de fermeture de la fenêtre en cours
     * @param actionEvent
     */
    @FXML
    default void closeHandle(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
