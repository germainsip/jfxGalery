package fr.tomoetek.jfxgalery.gui.exemple;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.effects.JFXDepthManager;
import fr.tomoetek.jfxgalery.gui.MainController;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExempleTileController implements Initializable {
    public JFXButton genBtn;
    public Label commentLab;
    public HBox boitePrincipale;
    private String btnName;

    public void setValues(String btnName,String comment) {
        genBtn.setText(btnName);
        commentLab.setText(comment);
        genBtn.setOnAction(actionEvent ->{
            try {
                MainController.ouvreSceneExemple(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXDepthManager.setDepth(boitePrincipale,1);
    }
}
