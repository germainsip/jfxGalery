package fr.tomoetek.jfxgalery.gui.buttons;

import fr.tomoetek.jfxgalery.tools.FenToolInterface;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.web.WebView;

import java.net.URISyntaxException;

public class LesBoutonsController implements FenToolInterface {


    public WebView webView;
    public Button btn1;
    public Button btn2;
    public Label res;
    public Button fermeButt;
    public ToggleButton toggleBtn;

    @Override
    public void closeHandle(ActionEvent actionEvent) {
        FenToolInterface.super.closeHandle(actionEvent);
    }

    @Override
    public void loadCours(String link,WebView webView) throws URISyntaxException {
        FenToolInterface.super.loadCours(link, webView);
    }

    public void initialize() throws URISyntaxException {

        loadCours("les-button-et-label", this.webView);
    }

    /**
     * Cette méthode récupère le texte du bouton cliqué
     * et envoie le texte "Le [bouton n°] vient d'être cliqué"
     * au label res
     *
     * @param actionEvent
     */
    public void writeOnLabel(ActionEvent actionEvent) {
        // récupération du bouton cliqué
        Button btnActive = (Button) actionEvent.getSource();
        //construction du message avec le texte du bouton
        String message = "Le " + btnActive.getText() + "\n vient d'être cliqué!";
        //envoie du message dans le label
        res.setText(message);
    }


    public void toggleAction(ActionEvent actionEvent) {
       if(toggleBtn.isSelected()){
           res.setStyle("-fx-border-color: #3c5c84; -fx-border-width: 5");
       }else {
           res.setStyle("");
       }

    }
}
