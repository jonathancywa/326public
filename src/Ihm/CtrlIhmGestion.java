/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ihm;

import Ctrl.Ctrl;
import beans.Grade;
import beans.User;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
 * contrôleur de l'ihm principale
 * @author Jonathan Gamez
 * @version 1.0
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
    private ComboBox<Grade> cmbx_grade;
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
    private boolean bdg;

    /**
     * constructeur
     * @param ctrl
     */
    public CtrlIhmGestion(Ctrl ctrl) {
       this.refCtrl = ctrl;
        popup = new Popup();
          fxml = "/Ihm/IhmGestionUser.fxml";
    }

    /**
     *permet de démarrer l'imh
     */
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
                lst_users.getItems().setAll(refCtrl.getUser()) ;
            } catch (IOException ex) {
                System.out.println("Can't start the IHM because : " + ex);
                Platform.exit();
            }
//        });
    }
    
    /**
     * 
     * @param nom nom de l'utilisateur
     * @param prenom prenom de l'utilisateur
     */
    @Override
    public void addUser(String nom, String prenom) {
       
    }

    /**
     *
     * @param user utilisateur a supprimer
     */
    @Override
    public void deleteUser(User user) {
      
    }

    /**
     *permet d'afficher les utilisateurs
     */
    @Override
    public void getUser() {
        try {
              lst_users.getItems().setAll(refCtrl.getUser()) ;
        } catch (Exception e) {
        }
    
    }
/**
 * permet de definir si l'utilisateur a le droit d'utiliser le badge
 * @param event 
 */
    @FXML
    private void cbx_badge(ActionEvent event) {
        bdg = cbx_badgeOk.selectedProperty().get();
        System.out.println(bdg);
    }
    /**
     * permet d'enregistrer les modification de l'utilisateur
     * @param event 
     */

    @FXML
    private void enregister(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.WARNING,"veuiller remplir tout les champ");
        User u = new User();
        if (txt_login.getText().isEmpty() || txt_password.getText().isEmpty()) {
          alert.show();
            
        }else{
            System.out.println("");
            refCtrl.addUser(txt_login.getText(), txt_password.getText());
            
        }
        getUser();
    }
/**
 * permet de supprimer l'utilisateur selectionner
 * @param event 
 */
    @FXML
    private void supprimer(ActionEvent event) {
        refCtrl.deleteUser(lst_users.getSelectionModel().getSelectedItem());
        getUser();
    }
/**
 * permet de recharger l'affichage des utilisateur
 * @param event 
 */
    @FXML
    private void reload(ActionEvent event) {
        lst_users.getItems().setAll(refCtrl.getUser()) ;
        cmbx_grade.getItems().setAll(refCtrl.getGrade());
    }
/**
 * permet d'ajouter un nouvelle utilisateur 
 * @param event 
 */
    @FXML
    private void nouveau(ActionEvent event) {
        refCtrl.addUser("new", "new");
        lst_users.getItems().setAll(refCtrl.getUser()) ;
        
    }
    
}
