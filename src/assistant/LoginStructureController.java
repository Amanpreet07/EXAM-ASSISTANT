package assistant;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// Purpose: To provide structure for different login fxmls
public class LoginStructureController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
    }
    
    private void removeUnd(int i){
        str_signIn.setText("Sign In");
        str_recovery.setText("Recover");
        str_signUp.setText("Sign Up");
        str_guest.setText("Guest");
        switch(i){
            case 1:
                str_signIn.setText("> Sign In");
                break;
            case 2:
                str_recovery.setText("> Recover");
                break;
            case 3:
                str_signUp.setText("> Sign Up");
                break;
            case 4:
                str_guest.setText("> Guest");
                break;
        }
    }
    
    @FXML
    private JFXTextField def_username;

    @FXML
    private JFXPasswordField def_password;

    @FXML
    private JFXButton def_login;

    @FXML
    private Label def_info;

    @FXML
    private JFXButton def_close;

    @FXML
    private JFXButton def_minimize;

    @FXML
    void action_close(ActionEvent event) {
        System.exit(0);
    }

    private double x, y;
    
    @FXML
    void action_def_login(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            }
        });
        
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    
    
    @FXML
    void action_minimize(ActionEvent event) {
       Stage stage = (Stage) str_anchor.getScene().getWindow(); 
       stage.setIconified(true);
    }
    
     @FXML
    private JFXButton str_signIn;

    @FXML
    private JFXButton str_signUp;

    @FXML
    private JFXButton str_guest;

    @FXML
    private JFXButton str_recovery;
    
    @FXML
    private AnchorPane str_anchor;

    @FXML
    void action_str_forgot(ActionEvent event) throws IOException {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("PasswordRecovery.fxml"));
        str_anchor.getChildren().clear();
        str_anchor.getChildren().add(ap);
        removeUnd(2);
    }
    
    @FXML
    void action_str_guest(ActionEvent event) throws IOException {

        AnchorPane ap = FXMLLoader.load(getClass().getResource("GuestLogin.fxml"));
        str_anchor.getChildren().clear();
        str_anchor.getChildren().add(ap);
        removeUnd(4);
    }

    @FXML
    void action_str_signIn(ActionEvent event) throws IOException {

        AnchorPane ap = FXMLLoader.load(getClass().getResource("DefaultLogin.fxml"));
        str_anchor.getChildren().clear();
        str_anchor.getChildren().add(ap);
        removeUnd(1);
    }

    @FXML
    void action_str_signUp(ActionEvent event) throws IOException {

        AnchorPane ap = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        str_anchor.getChildren().clear();
        str_anchor.getChildren().add(ap);
        removeUnd(3);
    }
    
     @FXML
    private JFXButton rec_update;

    @FXML
    private Label rec_info;

    @FXML
    private JFXButton rec_close;

    @FXML
    private JFXButton rec_minimize;

    @FXML
    private TextArea rec_question;

    @FXML
    private JFXTextField rec_answer;

    @FXML
    private JFXPasswordField rec_password;

    @FXML
    private JFXPasswordField rec_rePassword;

    @FXML
    void action_rec_update(ActionEvent event) {

    }
    
    @FXML
    private JFXTextField gue_name;

    @FXML
    private JFXButton gue_login;

    @FXML
    private Label gue_info;

    @FXML
    private JFXButton gue_close;

    @FXML
    private JFXButton gue_minimize;

    @FXML
    private JFXTextField gue_id;

    @FXML
    private JFXTextField gue_contact;

    @FXML
    void action_gue_login(ActionEvent event) {

    }

     @FXML
    private JFXTextField sign_username;

    @FXML
    private JFXButton sign_create;

    @FXML
    private Label sign_info;

    @FXML
    private JFXButton sign_close;

    @FXML
    private JFXButton sign_minimize;

    @FXML
    private JFXTextField sign_email;

    @FXML
    private JFXTextField sign_answer;

    @FXML
    private JFXComboBox<?> sign_question;

    @FXML
    private JFXPasswordField sign_password;

    @FXML
    private JFXPasswordField sign_rePassword;

    @FXML
    void action_sign_create(ActionEvent event) {

    }

    
}
