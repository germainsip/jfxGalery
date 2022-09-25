package fr.tomoetek.jfxgalery.gui.exemple;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.effects.JFXDepthManager;
import fr.tomoetek.jfxgalery.App;
import fr.tomoetek.jfxgalery.gui.MainController;
import fr.tomoetek.jfxgalery.model.Exemple;
import fr.tomoetek.jfxgalery.tools.FenToolInterface;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class ExempleTileController implements FenToolInterface {
    public JFXButton genBtn;
    public Label commentLab;
    public HBox boitePrincipale;
    private Exemple exemple;


    public void initialize() {
        JFXDepthManager.setDepth(boitePrincipale,1);
    }


    public void chargeChap() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("gui/"+this.exemple.getFxml()));
        try {
            Parent exFen = fxmlLoader.load();
            Scene scene =new Scene(exFen);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);

            stage.show();

            // Méthodes pour permettre le dragg de la fenêtre
            //TODO: à factoriser dans FenToolInterface
            AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
            AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);
            scene.setOnMousePressed(event -> {
                xOffset.set(stage.getX() - event.getScreenX());
                yOffset.set(stage.getY() - event.getScreenY());
            });
            scene.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() + xOffset.get());
                stage.setY(event.getScreenY() + yOffset.get());
            });

        } catch (Exception e){
            System.out.println(this.exemple.getFxml());
            System.out.println("Le path: "+ App.class.getResource("gui/"+this.exemple.getFxml()));

            System.out.println(e.getMessage()+" et cause:"+e.getCause());
        }

    }



    public void setExemple(Exemple ex){
        this.exemple = ex;
        genBtn.setText(this.exemple.getName());
        commentLab.setText(this.exemple.getComment());
    }



}
