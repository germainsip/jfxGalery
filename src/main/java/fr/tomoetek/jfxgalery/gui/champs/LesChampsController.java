package fr.tomoetek.jfxgalery.gui.champs;

import com.jfoenix.controls.JFXButton;
import fr.tomoetek.jfxgalery.tools.FenToolInterface;
import fr.tomoetek.jfxgalery.tools.Verification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.net.URISyntaxException;

public class LesChampsController implements FenToolInterface {
    public TextField nomField;
    public TextField prenomField;
    public TextField telField;
    public PasswordField passField;
    public Button sendButt;
    public Label nomLab;
    public Label prenomLab;
    public Label telLab;
    public Label passLab;
    public WebView webView;
    public JFXButton fermButt;

// TODO: transformer en singleton
    public void initialize() throws URISyntaxException {
loadCours("les_champs",this.webView);
    }

    @Override
    public void loadCours(String link, WebView webView) throws URISyntaxException {
        FenToolInterface.super.loadCours(link, webView);
    }

    @Override
    public void closeHandle(ActionEvent actionEvent) {
        FenToolInterface.super.closeHandle(actionEvent);
    }

    public void sendHandle() {

        boolean flagChampNom,flagChampPrenom,flagChampTel;

        if (Verification.verifTexte(nomField.getText()) ) {
            nomField.setStyle("");
            flagChampNom = true;
        } else {
            nomField.setStyle("-fx-border-color: darkred");
            flagChampNom = false;
        }if (Verification.verifTexte(prenomField.getText()) ) {
            prenomField.setStyle("");
            flagChampPrenom = true;
        } else {
            nomField.setStyle("-fx-border-color: darkred");
            flagChampPrenom = false;
        }if (Verification.verifNum(telField.getText()) ) {
            telField.setStyle("");
            flagChampTel = true;
        } else {
            telField.setStyle("-fx-border-color: darkred");
            flagChampTel = false;
        }

        if (flagChampNom && flagChampPrenom && flagChampTel) sendField();
    }

    private void sendField() {
        nomLab.setText(nomField.getText());
        prenomLab.setText(prenomField.getText());
        telLab.setText(telField.getText());
        passLab.setText(passField.getText());
    }
}
