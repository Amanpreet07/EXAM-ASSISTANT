
package assistant.dashboard;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class DashboardMainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VBox vbox = null;
        try {
            vbox = FXMLLoader.load(getClass().getResource("Notifications.fxml"));
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        
        drawer.setSidePane(vbox);
        HamburgerBasicCloseTransition bt = new 
           HamburgerBasicCloseTransition(hamburger);
        bt.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            bt.setRate(bt.getRate()*-1);
            bt.play();
            if(drawer.isShown()){
                drawer.close();
            }else{
             drawer.open();
            }
        });
        
    }    
    
     @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;
    
    
    
}
