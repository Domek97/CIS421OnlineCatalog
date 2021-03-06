package cis421onlinecatalog;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private void handleButtonAction(ActionEvent event){
        if (event.getSource() == signUpButton) {
            signUp(emailField.getText(), usernameField.getText(), passwordField.getText(), confirmPasswordField.getText(), streetField.getText(), aptField.getText(), cityField.getText(), zipField.getText());
        }
        else if (event.getSource() == cancelButton) {
            cancelSignUp(event);
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
        
        CIS421OnlineCatalog add = new CIS421OnlineCatalog();
        try {
            
            add.insertUser(emailField.getText(), usernameField.getText(), passwordField.getText());
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CIS421OnlineCatalog address = new CIS421OnlineCatalog();
        try {
            address.insertAddress(emailField.getText(), streetField.getText(), cityField.getText(), (String) stateComboBox.getValue(), aptField.getText(),  zipField.getText());
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void cancelSignUp(ActionEvent event) {
        try {
            Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLDocumentLogin.fxml"));
            Scene home_scene = new Scene(home_parent);
            Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            home_stage.setScene(home_scene);
            home_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerSignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
