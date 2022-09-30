package fr.tomoetek.jfxgalery.gui.sliders;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import fr.tomoetek.jfxgalery.tools.FenToolInterface;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Arc;
import javafx.scene.web.WebView;

import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.Format;

public class LesSlidersController implements FenToolInterface {
    public Slider hSlide;
    public Slider vSlide;
    public Label horizonLab;
    public Label verticalLab;
    public JFXSlider hSliderJFX;
    public Arc greenArc;
    public WebView webView;
    public JFXButton fermeButt;


    public void initialize(){
        hSlide.valueProperty().addListener((obs,oldValue,newValue)->{
                Format df = new DecimalFormat("#.##");
                String horizonValue = df.format(hSlide.getValue());

                horizonLab.setText("H: " + horizonValue);
        });
        vSlide.valueProperty().addListener((obs,oldValue,newValue)->{
            Format df = new DecimalFormat("#.##");
            String verticalValue = df.format(vSlide.getValue());
            verticalLab.setText("V: "+verticalValue);

        });
        hSliderJFX.valueProperty().addListener((obs,oldValue,newValue)->{
            greenArc.setLength(hSliderJFX.getValue());
        });

    }

    @Override
    public void loadCours(String link, WebView webView) throws URISyntaxException {
        FenToolInterface.super.loadCours(link, webView);
    }

    @Override
    public void closeHandle(ActionEvent actionEvent) {
        FenToolInterface.super.closeHandle(actionEvent);
    }


}
