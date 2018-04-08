package assistant.profile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class Profile_MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }   
    
    @FXML
    private Circle avatar;

    @FXML
    private Label name;

    @FXML
    private Label gender;

    @FXML
    private Label age;

    @FXML
    private Label doc;

    @FXML
    private Label position;

    @FXML
    private Label iid;

    @FXML
    private Label institution;

    @FXML
    private Label itype;

    @FXML
    private Label contact;

    @FXML
    private Label email;

    @FXML
    private Label twitter;

    @FXML
    private Label linkedin;

    @FXML
    void action_edit(ActionEvent event) {

    }

    
}
