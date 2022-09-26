package fr.tomoetek.jfxgalery.tools;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;
import fr.tomoetek.jfxgalery.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * L'interface FenToolInterface est utilisée pour ajouter les fonctionnalités récurrentes de l'application
 */
public interface FenToolInterface {
    // JFXButton fermeButt = new JFXButton();
    // String exempleFxml = "";

    /**
     * Charge un ficher markdown et le parse en html + style
     * @param link chemin vers le md
     * @param webView
     * @throws URISyntaxException
     */
    default void loadCours(String link, WebView webView) throws URISyntaxException {
        String chem = getClass().getPackageName();
        String[] chemTab= chem.split("\\.");
        System.out.println(chemTab[4]);
        link += ".md";
        link = String.join("/","gui",chemTab[4],link);
        System.out.println(link);
        try (InputStream in = App.class.getResourceAsStream(link)) {
           // assert in != null;
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);

            MutableDataSet options = new MutableDataSet();

            Parser parser = Parser.builder(options).build();
            HtmlRenderer renderer = HtmlRenderer.builder(options).build();

            com.vladsch.flexmark.util.ast.Node document = parser.parse(contents);
            String html = renderer.render(document);
            String css = (App.class.getResourceAsStream("gui/retro.css") != null)? IOUtils.toString(
                    App.class.getResourceAsStream("gui/retro.css"), StandardCharsets.UTF_8
            ):"";

            html = "<style>"+css+"</style>"+html;


            webView.getEngine().loadContent(html);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Méthode de fermeture de la fenêtre en cours
     *
     * @param actionEvent
     */
    @FXML
    default void closeHandle(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
