package cis421onlinecatalog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Dominic Santangelo
 */
public class FXMLDocumentControllerCheckoutDialog implements Initializable {
    String connectionUrl;
    
    @FXML private Label totalCostLabel, paymentMethodLabel;
    @FXML private ComboBox paymentMethodComboBox;
    @FXML private Button backButton, checkoutButton;
    @FXML private CheckBox useSavedInfoBox, saveInformationBox;
    @FXML private TextField cardNumberPaypalEmailField;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == backButton) {
            closeStage(event);
        }
        else if (event.getSource() == checkoutButton) {
            checkout();
        }
    }
    
    @FXML
    private void checkSavedInfo() {
        if (useSavedInfoBox.isSelected()) {
            if(paymentMethodComboBox.getValue().equals("Credit card")) {
                System.out.println("Test1");
                //TODO: create a query that gets user's credit card number
                //cardNumberPaypalEmailField.setText(paypalEmail);
            } 
            else if (paymentMethodComboBox.getValue().equals("Paypal")) {
                System.out.println("Test2");
                //TODO: create a query that gets user's paypal email
                // cardNumberPaypalEmailField.setText(paypalEmail);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paymentMethodComboBox.getItems().addAll("Credit card", "Paypal");
        paymentMethodComboBox.setValue("Credit card");
        
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //connectionUrl = "jdbc:sqlserver://localhost:1433;" +
        //            "databaseName=onlineCatalog;integratedsecurity = true";
        //String userQuery = "SELECT Username, EmailAddress FROM USERS WHERE Username = \'" + username + "\' AND Password = \'" + password + "\'";
    }    

    private void checkout() {
        if (!paymentMethodComboBox.getValue().equals("") && !cardNumberPaypalEmailField.getText().trim().isEmpty()) {
            //TODO: Update user's payment info in database if saveInformationBox.isSelected(), then remove every row in cart database from current user
        }
    }
    
    private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
