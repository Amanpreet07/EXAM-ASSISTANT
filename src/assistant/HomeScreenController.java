package assistant;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HomeScreenController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }
    
    @FXML
    private JFXButton home_dashboard;

    @FXML
    private JFXButton home_profile;

    @FXML
    private JFXButton home_blueprint;

    @FXML
    private JFXButton home_bank;

    @FXML
    private JFXButton home_institution;

    @FXML
    private JFXButton home_paper;

    @FXML
    private JFXButton home_settings;

    @FXML
    private JFXButton home_help;

    private void mark(int i) {
        home_bank.setText("Q-BANK");
        home_blueprint.setText("BLUEPRINTS");
        home_dashboard.setText("DASHBOARD");
        home_help.setText("HELP");
        home_institution.setText("INSTITUTION");
        home_paper.setText("PAPER");
        home_profile.setText("PROFILE");
        home_settings.setText("SETTINGS");

        switch (i) {
            case 1: home_dashboard.setText("DASHBOARD >>");
                break;
            case 2: home_profile.setText("PROFILE >>");
                break;
            case 3: home_blueprint.setText("BLUEPRINTS >>");
                break;
            case 4: home_bank.setText("Q-BANK >>");
                break;
            case 5: home_institution.setText("INSTITUTION >>");
                break;
            case 6: home_paper.setText("PAPER >>");
                break;
            case 7: home_settings.setText("SETTINGS >>");
                break;
            case 8: home_help.setText("HELP >>");
                break;
        }

    }

    @FXML
    void action_bank(ActionEvent event) {
        mark(4);
    }

    @FXML
    void action_blueprint(ActionEvent event) {
        mark(3);
    }

    @FXML
    void action_close(ActionEvent event) {
        
    }

    @FXML
    void action_dashboard(ActionEvent event) {
        mark(1);
    }

    @FXML
    void action_help(ActionEvent event) {
        mark(8);
    }

    @FXML
    void action_institution(ActionEvent event) {
        mark(5);
    }   

    @FXML
    void action_minimize(ActionEvent event) {
       Stage stage = (Stage) home_bank.getScene().getWindow(); 
       stage.setIconified(true);
       
    }

    private boolean maximised;
    
    @FXML
    void action_maximize(ActionEvent event) {
          
       Stage stage = (Stage) home_bank.getScene().getWindow(); 
       Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
       if(!maximised){
       stage.setX(primaryScreenBounds.getMinX());
       stage.setY(primaryScreenBounds.getMinY());
       stage.setWidth(primaryScreenBounds.getWidth());
       stage.setHeight(primaryScreenBounds.getHeight());
       maximised = true;
       }else{
       stage.setWidth(980);
       stage.setHeight(550.0);
       stage.centerOnScreen();
       maximised = false;
       }
       
    }
    
    @FXML
    void action_paper(ActionEvent event) {
        mark(6);
    }

    @FXML
    void action_profile(ActionEvent event) {
        mark(2);
    }

    @FXML
    void action_settings(ActionEvent event) {
        mark(7);
    }

}
