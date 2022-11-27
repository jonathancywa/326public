/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ihm;

import Ctrl.Ctrl;
import beans.User;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import other.Popup;
//import app.helpers.JfxPopup;
/**
 *
 * @author 5.1
 */
public class CtrlIhmGestion implements CtrlIhmGestionUser{

    @FXML
    private ListView<User> lst_users;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_login;
    @FXML
    private TextField txt_password;
    @FXML
    private TextField txt_tag;
    @FXML
    private CheckBox cbx_badgeOk;
    @FXML
    private ComboBox<?> cmbx_grade;
    @FXML
    private Button btn_enregister;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_reload;
    @FXML
    private Button btn_nouveau;
    private Ctrl refCtrl;
    private Popup popup;
    private final String fxml;
    private Scene principalScene;
    private Stage mainStage;
    public CtrlIhmGestion() {
        refCtrl = new Ctrl();
        popup = new Popup();
          fxml = "/Ihm/IhmGestionUser.fxml";
    }
    public void start(){
          Callback<Class<?>, Object> controllerFactory = type -> {
            return this;
        };

        // Seulement si JDK <= 8 (il faudra faire un « fix imports » !)
   //    PlatformImpl.startup(() -> {
        // Seulement si JDK > 8 (il faudra faire un « fix imports » !), nouvelle méthode standardisée par Java
//        Platform.startup(() -> {
            try {
                mainStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
                fxmlLoader.setControllerFactory(controllerFactory);
                Parent root = (Parent) fxmlLoader.load();
                principalScene = new Scene(root);
                mainStage.setScene(principalScene);
                mainStage.setTitle("java");
                mainStage.setMinWidth(900);   // Pour limiter la taille min
                mainStage.setMinHeight(750);   // Pour limiter la taille min

                mainStage.setOnCloseRequest((WindowEvent e) -> {

                });

                mainStage.show();
            } catch (IOException ex) {
                System.out.println("Can't start the IHM because : " + ex);
                Platform.exit();
            }
//        });
    }
    
    
    @Override
    public void addUser(String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getUser() {
      lst_users.getItems().addAll(refCtrl.getUser()) ;
    }

    @FXML
    private void cbx_badge(ActionEvent event) {
        
    }

    @FXML
    private void enregister(ActionEvent event) {
        if (txt_login.getText().isEmpty() || txt_password.getText().isEmpty()) {
            System.out.println("popup nok");
        }else{
            System.out.println("");
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void reload(ActionEvent event) {
    }

    @FXML
    private void nouveau(ActionEvent event) {
        refCtrl.addUser("new", "new");
        
    }
    
}
