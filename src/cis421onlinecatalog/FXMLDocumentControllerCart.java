package cis421onlinecatalog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Dominic Santangelo
 */
public class FXMLDocumentControllerCart implements Initializable {
    
    @FXML   
    private Label label;
    @FXML private TableView cartTableView;
    @FXML private TableColumn<Product, String> nameCol, brandCol;
    @FXML private TableColumn<Product, Integer> priceCol, quantityCol;
    @FXML private Button backButton, checkoutButton;
    ObservableList<Product> cartList = FXCollections.observableArrayList();
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == backButton) {
            back(event);
        }
        else if (event.getSource() == checkoutButton) {
            checkout();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initList();
        
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        brandCol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject()); 
        quantityCol.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        
        cartTableView.setItems(cartList);
    }    

    private void initList() {
        //TODO: pull data from the database from table CART to populate cartList
        //I recommend saving each tuple from the database to a temporary Product object (see Product.java) and then using "productList.add(tempProduct);"
        
        //this filler data is just to show that the table works. it should be deleted after implementation
        Product tempProduct = new Product("111111111111", "Straight-up Oil", "Suave", "Bath & Body", 5, 25 );
        cartList.add(tempProduct);
    }

    private void back(ActionEvent event) {
        try {
            Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLDocumentBrowse.fxml"));
            Scene home_scene = new Scene(home_parent);
            Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            home_stage.setScene(home_scene);
            home_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void checkout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocumentCheckoutDialog.fxml"));
            Parent parent = fxmlLoader.load();
            
            Scene scene = new Scene(parent, 300, 200);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
