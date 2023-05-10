package com.imageviewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;

/**
 * JavaFX App
 */
public class App extends Application {

    static Scene scene;
    static Stage stage;
    
    public static void main(String[] args) {
        App.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(App.class.getResource("iv.fxml"));
        AnchorPane anchor = loader.load();
        scene = new Scene(anchor);
        this.stage = stage;
        
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.setMaximized(true);
        
    }
}