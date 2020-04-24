package cis421onlinecatalog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Dominic Santangelo
 */
public class FXMLDocumentControllerSignUp implements Initializable {
    
    @FXML   
    private Label failedSignUpAttempt;
    @FXML ComboBox stateComboBox;
    @FXML TextField emailField, usernameField, streetField, aptField, cityField, zipField;
    @FXML PasswordField passwordField, confirmPasswordField;
    @FXML Button signUpButton, cancelButton;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == signUpButton) {
            signUp(emailField.getText(), usernameField.getText(), passwordField.getText(), confirmPasswordField.getText(), streetField.getText(), aptField.getText(), cityField.getText(), zipField.getText());
        }
        else if (event.getSource() == cancelButton) {
            cancelSignUp();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stateComboBox.getItems().addAll( "AL", "AK" , "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
                                        "HI", "ID", "IL","IN", "IA", "KS", "KY", "LA", "ME", "MD",
                                        "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                                        "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                                        "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
        );
        
    }    
    
    protected void signUp(String email, String username, String password, String passwordConfirm, String street, String apt, String city, String zip) {
        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty() || street.isEmpty() || city.isEmpty() || zip.isEmpty()) {
            passwordField.clear();
            confirmPasswordField.clear();
        }
    }
    
    protected void cancelSignUp() {
        //TODO: Take the user back to login screen
    }
}
