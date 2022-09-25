package fr.tomoetek.jfxgalery.tools;

import com.jfoenix.controls.JFXButton;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

/**
 * L'interface FenToolInterface est utilisée pour ajouter les fonctionnalités récurrentes de l'application
 */
public interface FenToolInterface {
    JFXButton fermeButt = new JFXButton();
    String exempleFxml = "";

    default void loadCours(String link,WebView webView) throws URISyntaxException {
        File file = new File(App.class.getResource("gui/buttons/les_boutons.md").toURI());

        try (InputStream in = new FileInputStream(file))
        {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
            System.out.println(contents);

            MutableDataSet options = new MutableDataSet();

            // uncomment to set optional extensions
            //options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));

            // uncomment to convert soft-breaks to hard breaks
            //options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

            Parser parser = Parser.builder(options).build();
            HtmlRenderer renderer = HtmlRenderer.builder(options).build();

            // You can re-use parser and renderer instances
            com.vladsch.flexmark.util.ast.Node document = parser.parse(contents);
            String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
            System.out.println(html);


            //webView.getEngine().load(String.format("https://germainsip.github.io/post/cours/java/javafxelmts/#%s", link));

            webView.getEngine().setUserStyleSheetLocation(App.class.getResource("gui/style.css").toString());

            webView.getEngine().loadContent(html);

        }
        catch (IOException e) {
            e.printStackTrace();
        }




    }

    /**
     * Méthode de fermeture de la fenêtre en cours
     * @param actionEvent
     */
    @FXML
    default void closeHandle(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
