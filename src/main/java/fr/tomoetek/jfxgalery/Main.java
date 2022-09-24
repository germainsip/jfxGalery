package fr.tomoetek.jfxgalery;

import fr.tomoetek.jfxgalery.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gui/les_boutons.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("JFX Galerie");
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
