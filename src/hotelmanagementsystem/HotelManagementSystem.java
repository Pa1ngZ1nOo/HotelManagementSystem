/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.IOException;
//import java.time.Duration;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Lenovo
 */
public class HotelManagementSystem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/hotelmanagementsystem/LOGINFXML.fxml"));
        
        Scene scene = new Scene(root);
        FadeTransition f = new FadeTransition(Duration.seconds(3),root);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();
        
        stage.setTitle("Hotel Management System");
        stage.getIcons().add(new Image("/image/LOGO.png"));
        stage.setResizable(false);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
