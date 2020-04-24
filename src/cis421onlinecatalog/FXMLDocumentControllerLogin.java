package cis421onlinecatalog;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            login(usernameField.getText(), passwordField.getText(), event);
        }
        else if (event.getSource() == signUpButton) {
            signUpScreen(event);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        failedLoginLabel.setVisible(false);
    }    
    
    protected void login(String username, String password, ActionEvent event) {
        try {
            usernameField.clear();
            passwordField.clear();
            //TODO: check if username/password match the database
            Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLDocumentBrowse.fxml"));
            Scene home_scene = new Scene(home_parent);
            Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            home_stage.setScene(home_scene);
            home_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void signUpScreen(ActionEvent event) {
        try {
            Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLDocumentSignUp.fxml"));
            Scene home_scene = new Scene(home_parent);
            Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            home_stage.setScene(home_scene);
            home_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
