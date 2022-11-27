package Ihm;

import Ctrl.Ctrl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

/**
 * @author GamezJ
 * @version 1.0
 * 
 */
public class Ihm implements ItfIhmCtrl {

    private Button btnGestionUser;
    private Button btnInitialise;
//	private Fenetre fenetre;
//	private ImgView imgView;
    private Ctrl refCtrl;
  
    @FXML
    private ImageView img_video;
    @FXML
    private Button btn_gestionUser;
    @FXML
    private Button btn_robot;
    private int igm = 0;
    private CtrlIhmGestion ihmUser;

    /**
     * constructeur ihm, définit le fichier a utiliser pour l'ihm
     */
    public Ihm() {
        fxml = "/Ihm/Ihm.fxml";
        refCtrl = null;
        
    }

    /**
     *
     * @param refCtrl set la reférence controleur
     */
    public void setRefCtrl(Ctrl refCtrl) {
        this.refCtrl = refCtrl;
        ihmUser = new CtrlIhmGestion(refCtrl);
    }

    /**
     *permet de démmarer l'ihm
     */
    
    public void start() {
        /*
         * Callback pour le ControllerFactory, quand JavaFX voudra créer le
         * controlleur de vue,
         * viendra dans ce callback et donnera l'instance déjà créée au lieu
         * d'en faire une
         * nouvelle.
         */
        Callback<Class<?>, Object> controllerFactory = type -> {
            return this;
        };

        // Seulement si JDK <= 8 (il faudra faire un « fix imports » !)
//        PlatformImpl.startup(() -> {
        // Seulement si JDK > 8 (il faudra faire un « fix imports » !), nouvelle méthode standardisée par Java
        Platform.startup(() -> {
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
        });
    }

    /**
     * permet de définir l'état dse bouton
     * @param btn
     * @param isEnabled
     * @deprecated pas implémenter
     */
    public void setBtn(Button btn, boolean isEnabled) {

    }

    /**
     * permet d'afficher une image
     * @param image image a afficher
     */
    @Override
    public void showVideo(byte[] image) {
       
        img_video.setImage(new Image(new ByteArrayInputStream(image)));
        
    }
/**
 * permet d'ouvrire l'ihm de gestion des utilisateur
 * @param event 
 */
    @FXML
    private void act_btn_gestionUser(ActionEvent event) {
        ihmUser.start();
      
     
        
    }
/**
 * permet de connecter le robot
 * @param event 
 */
    @FXML
    private void act_btn_robot(ActionEvent event) {

        if (refCtrl.robotIsConnected()) {

            refCtrl.deconnecterRobot();
            btn_robot.setText("Connecter Robot");
            img_video.setVisible(false);
        } else if (!refCtrl.robotIsConnected()) {
            img_video.setVisible(true);
            refCtrl.initialiseRobot();
            btn_robot.setText("Deconexion");
        }
    }
    private final String fxml;
    private Scene principalScene;
    private Stage mainStage;
}//end Ihm
