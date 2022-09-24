package fr.tomoetek.jfxgalery.gui;

import com.jfoenix.controls.JFXButton;
import fr.tomoetek.jfxgalery.App;
import fr.tomoetek.jfxgalery.gui.exemple.ExempleTileController;
import fr.tomoetek.jfxgalery.model.Exemple;
import fr.tomoetek.jfxgalery.tools.FenToolInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        //System.out.println("salut");
        Exemple[] exTab = {
                new Exemple("Les boutons","boutons actionable de JFX","les_boutons.fxml"),

        };
        for (Exemple ex : exTab)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("gui/"+ex.getExempleFxml()));
            Parent exFen = fxmlLoader.load();
            ExempleTileController controller = fxmlLoader.getController();
            controller.setExemple(ex);
           // controller.setValues(ex.getName(), ex.getComment());
            listBox.getChildren().add(exFen);

        }
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("exemple_tile.fxml"));
        /*try {
            Parent exFen = fxmlLoader.load();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }*/

    }

    /**
     * La méthode prend le texte du bouton et envoie le fxml correspondant
     *
     * @param actionEvent
     * @throws IOException
     */
    public static void ouvreSceneExemple(ActionEvent actionEvent) throws IOException {
        /*Button btn = (Button) actionEvent.getSource();
        String evenement = btn.getText();
        String action = GuiTool.route(evenement);

        // génère et lance un stage avec les éléments fournis
        Stage exempleStage = new Stage();
        Parent exempleRoot = loadFenExemple(action);
        Scene buttScene = new Scene(exempleRoot);
        exempleStage.setScene(buttScene);
        // enlève la bordure os de la le fenêtre
        exempleStage.initStyle(StageStyle.UNDECORATED);
        exempleStage.show();

        // Méthodes pour permettre le dragg de la fenêtre
        buttScene.setOnMousePressed(event -> {
            xOffset = exempleStage.getX() - event.getScreenX();
            yOffset = exempleStage.getY() - event.getScreenY();
        });
        buttScene.setOnMouseDragged(event -> {
            exempleStage.setX(event.getScreenX() + xOffset);
            exempleStage.setY(event.getScreenY() + yOffset);
        });*/
    }


}
