package fr.tomoetek.jfxgalery.gui;

import com.jfoenix.controls.JFXButton;
import fr.tomoetek.jfxgalery.App;
import fr.tomoetek.jfxgalery.gui.exemple.ExempleTileController;
import fr.tomoetek.jfxgalery.model.Exemple;
import fr.tomoetek.jfxgalery.tools.FenToolInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController implements FenToolInterface {


    public TreeView arbre;
    public JFXButton fermeButt;
    public VBox listBox;



    @Override
    public void closeHandle(ActionEvent actionEvent) {
        FenToolInterface.super.closeHandle(actionEvent);
    }

    private static double xOffset;
    private static double yOffset;

    public void initialize() throws IOException {
        Exemple[] exTab = {
                new Exemple("Les boutons et labels","boutons actionable de JFX","buttons/les_boutons.fxml"),

        };
        for (Exemple ex : exTab)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ex.getExempleFxml()));
            Parent exFen = fxmlLoader.load();
            ExempleTileController controller = fxmlLoader.getController();
            controller.setExemple(ex);
            listBox.getChildren().add(exFen);

        }


    }


    }



