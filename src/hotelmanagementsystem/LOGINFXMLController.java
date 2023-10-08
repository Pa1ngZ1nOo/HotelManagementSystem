/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import static hotelmanagementsystem.DataAccessDB.SQLSelect;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class LOGINFXMLController implements Initializable {

    @FXML
    private ImageView img;

    @FXML
    private TextField txtUser;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPass;

//    @FXML
//    private Button btnClose;
//    private Connection connection;
//    private Statement stmt;
    private ResultSet rs;
    Alert alert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void login(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String user = txtUser.getText();
        String pass = txtPass.getText();
        String sql = "SELECT * FROM loginuser WHERE username= '" + user + "' and password = '" + pass + "' ";

        try {
            rs = SQLSelect(sql);

            if (user.isEmpty() || pass.isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                Stage stage = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                alert.initOwner(stage);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please type Username and Password");
                alert.showAndWait();
                clear();
            } else {
                if (rs.next()) {
                    //beta.2 START
//                    alert = new Alert(Alert.AlertType.INFORMATION);
//                    Stage stage = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
//                    alert.initOwner(stage);
//                    alert.setTitle("Information Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Successfully Login !");
//                    alert.showAndWait();
                    //beta.2 END

                    btnLogin.getScene().getWindow().hide();

//                    Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                    Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                    //Modified Codes Start
                    Region contentRootRegion = (Region) root;
                    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                    double oriW = d.width;
                    double oriH = d.height;
                    if (contentRootRegion.getPrefWidth() == Region.USE_COMPUTED_SIZE) {
                        contentRootRegion.setPrefWidth(oriW);
                    } else {
                        oriW = contentRootRegion.getPrefWidth();
                    }

                    if (contentRootRegion.getPrefHeight() == Region.USE_COMPUTED_SIZE) {
                        contentRootRegion.setPrefHeight(oriH);
                    } else {
                        oriH = contentRootRegion.getPrefHeight();
                    }
                    //modified Code END

                    Stage stageDash = new Stage();
                    Scene scene = new Scene(root, oriW, oriH);
                    stageDash.setTitle("Hotel Management System");
                    stageDash.getIcons().add(new Image("/image/LOGO.png"));
                    stageDash.setResizable(false);

                    //beta.2 START
                    stageDash.setOnCloseRequest(e -> {
                        e.consume(); // stop the event to do something before quitting

                        try {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            Stage owner = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                            alert.initOwner(owner);
                            alert.setTitle("Confirmation Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Are you sure?");
                            Optional<ButtonType> option = alert.showAndWait();

                            if (option.get().equals(ButtonType.OK)) {
                                Parent rootLogin = FXMLLoader.load(getClass().getResource("LOGINFXML.fxml"));
                                Stage stage = new Stage();
                                stage.setTitle("Hotel Management System");
                                stage.getIcons().add(new Image("/image/LOGO.png"));
                                stage.setResizable(false);
                                Scene sceneLogin = new Scene(rootLogin);
                                stage.setScene(sceneLogin);
                                stageDash.close();
                                stage.show();                                 
                            } else {
                                return;
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    });
                    //beta.2 END

                    stageDash.setScene(scene);
                    stageDash.show();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    Stage stage = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                    alert.initOwner(stage);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("LOGIN FAILED !");
                    alert.showAndWait();
                    clear();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void clear() {
        txtUser.clear();
        txtPass.clear();
    }

}
