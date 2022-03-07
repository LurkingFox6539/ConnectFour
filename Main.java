/*  Main Class
 *  March 7th, 2022
 *  Plays connect four, function names are self-explanatory
 *  I'd try to document more but this project totalled almost 1600 lines of code
 *  and a large portion of it was done in one sitting
 */

package com.example.connectfour;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        URL css = new URL("file:///" +
                new File("src/main/java/com/example/connectfour/").getAbsolutePath().replace("\\", "/") +
                "/application.css");
        scene.getStylesheets().add(css.toExternalForm());

        stage.setTitle("Connect Four");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });
    }
    public void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit the game.");
        alert.setContentText("Any unsaved data will be lost, do you still wish to exit?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}