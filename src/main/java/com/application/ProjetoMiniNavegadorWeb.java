package com.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ProjetoMiniNavegadorWeb extends Application {
    @Override
    public void start(Stage palco){
        TextField campoURL = new TextField();
        WebView navegador = new WebView();
        WebEngine motor = navegador.getEngine();

        // carrega uma página da Web quando o usuario pressiona enter:
        campoURL.setOnAction(evento -> motor.load(formataURL(campoURL.getText())));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(campoURL, navegador);
        Scene cena = new Scene(vBox);

        palco.setTitle("Meu Browser Java");
        palco.setScene(cena);
        palco.show();


    }
    public static void main(String[] args) {
        launch(args);
    }

    public String formataURL (String url){
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        return url;
    }
}