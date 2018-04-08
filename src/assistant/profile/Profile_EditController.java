package assistant.profile;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Profile_EditController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
    @FXML
    private JFXTextField name;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup radio_group;

    @FXML
    private RadioButton female;

    @FXML
    private JFXSlider age;

    @FXML
    private Label age_label;

    @FXML
    private JFXTextField iName;

    @FXML
    private JFXTextField iProfile;

    @FXML
    private JFXTextField iId;

    @FXML
    private RadioButton school;

    @FXML
    private ToggleGroup radio_group1;

    @FXML
    private RadioButton college;

    @FXML
    private RadioButton training;

    @FXML
    private RadioButton other;

    @FXML
    private JFXTextField contact;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField twitter;

    @FXML
    private JFXTextField linkedin;

    @FXML
    void action_cancel(ActionEvent event) {

    }

    @FXML
    void action_update(ActionEvent event) {

    }

    
}
