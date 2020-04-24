package cis421onlinecatalog;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public Statement stmt;
    public Connection conn;
    public String connectionUrl;
    ResultSet rs;
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
        try {
            failedLoginLabel.setVisible(false);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=onlineCatalog;integratedsecurity = true";
            
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    protected void login(String username, String password, ActionEvent event) {
        String emailFromDB = "", usernameFromDB = "";
        usernameField.clear();
        passwordField.clear();
        
    String userQuery = "SELECT Username, EmailAddress FROM USERS WHERE Username = \'" + username + "\' AND Password = \'" + password + "\'";
        System.out.println(userQuery);
        try {

            try {
                conn = DriverManager.getConnection(connectionUrl);
                PreparedStatement preparedStatement = conn.prepareStatement(userQuery);
                rs = preparedStatement.executeQuery();
            while (rs.next()) {
                usernameFromDB = rs.getString("Username");
                emailFromDB = rs.getString("emailAddress");
                Context.getInstance().currentUser().setUsername(usernameFromDB);
                Context.getInstance().currentUser().setEmailAddress(emailFromDB);
            }
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(!emailFromDB.equals("")) {
                Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLDocumentBrowse.fxml"));
                Scene home_scene = new Scene(home_parent);
                Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                home_stage.setScene(home_scene);
                home_stage.show();
            }
            else {
                failedLoginLabel.setVisible(true);
            }
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
