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
        System.out.println(getClass().getResource("gui/exemple_tile.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gui/exemple_tile.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("JFX Galerie");
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
