package cis421onlinecatalog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author Dominic Santangelo
 */
public class FXMLDocumentControllerAdminDialog implements Initializable {
    
    @FXML private Label label;
    @FXML private Button continueButton, cancelButton;
    @FXML private TextField pinField;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == continueButton) {
           //adminAccess = continueToAdmin(event);
        }
        else if(event.getSource() == cancelButton) {
            cancel(event);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //TODO
    }

    private void cancel(ActionEvent event) {
        closeStage(event);
    }
    private boolean continueToAdmin(ActionEvent event) {
        //TODO: check if PIN entered matches current user's PIN in the database. for now accepts any input so we can view the screen
        return true;
    }
    private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
