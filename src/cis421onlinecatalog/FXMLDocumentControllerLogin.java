package cis421onlinecatalog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Dominic Santangelo
 */
public class FXMLDocumentControllerLogin implements Initializable {
    
    @FXML private Label failedLoginLabel;
    @FXML private TextField usernameField, passwordField;
    @FXML private Button loginButton, signUpButton;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == loginButton) {
            login(usernameField.getText(), passwordField.getText());
        }
        else if (event.getSource() == signUpButton) {
            signUpScreen();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        failedLoginLabel.setVisible(false);
    }    
    
    protected void login(String username, String password) {
        usernameField.clear();
        passwordField.clear();
        //TODO: check if username/password match the database
    }
    
    protected void signUpScreen() {
        //TODO: swap to sign up screen
    }
}
