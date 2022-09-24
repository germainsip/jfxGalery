package fr.tomoetek.jfxgalery.tools;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.web.WebView;

/**
 * L'interface FenToolInterface est utilisée pour ajouter les fonctionnalités récurrentes de l'application
 */
public interface FenToolInterface {
    public WebView webView = new WebView();
    public JFXButton fermeButt = new JFXButton();

    public default void loadCours(String link){
        webView.getEngine().load(String.format("https://germainsip.github.io/post/cours/java/javafxelmts/#%s", link));

    }

    /**
     * Méthode de fermeture de la fenêtre en cours
     * @param actionEvent
     */
    @FXML
    public default void closeHandle(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
