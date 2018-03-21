package assistant;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Purpose: Launcher class
public class ExamAssistant extends Application {
 
    @Override
    public void start(Stage stage) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("EXAM ASSISTANT");
        stage.centerOnScreen();
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
