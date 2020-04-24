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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author Dominic Santangelo
 */
public class FXMLDocumentControllerBrowse implements Initializable {
    
    @FXML protected TableView productTableView, categoryTableView;
    @FXML private TableColumn<Product, String> nameCol, brandCol, upcCol, categoryCol;
    @FXML private TableColumn<Product, Integer> priceCol, stockCol;
    @FXML private Button viewCartButton, addToCartButton, adminSettingsButton, logOutButton;
    ObservableList<Product> productList = FXCollections.observableArrayList();
    ObservableList<Product> categoryList = FXCollections.observableArrayList();
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == logOutButton) {
            logOut(event);
        }
        else if(event.getSource() == adminSettingsButton) {
            viewAdminSettings(event);
        }
        else if(event.getSource() == addToCartButton) {
            addToCart();
        }
        else if(event.getSource() == viewCartButton) {
            viewCart(event);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initLists();
    
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty()); //setting the columns for the tableview
        brandCol.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        upcCol.setCellValueFactory(cellData -> cellData.getValue().upcProperty()); //setting the columns for the tableview
        categoryCol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject()); //setting the columns for the tableview
        stockCol.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        
        productTableView.setItems(productList);
        categoryTableView.setItems(categoryList);
    }    
    private void initLists() {
        //TODO: Initialize categoryTableView and productTableView
        Product tempProduct = new Product("111111111111", "Straight-up Oil", "Suave", "Bath & Body", 5, 25 );
        productList.add(tempProduct);
        tempProduct = new Product("222222222222", "The poo poo", "Microsoft", "Bath & Body", 99, 1);
        productList.add(tempProduct);
        if (!categoryTableView.getItems().contains(tempProduct.categoryProperty())) { //this is to ensure the same category doesn't show up twice
            categoryList.add(tempProduct);
        }
    }

    private void viewCart(ActionEvent event) {
        try {
            Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLDocumentCart.fxml"));
            Scene home_scene = new Scene(home_parent);
            Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            home_stage.setScene(home_scene);
            home_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBrowse.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TODO: Track currentUser as they navigate
    }

    private void addToCart() {
        //TODO: Add product selection to user's cart and save it to the database
    }

    private void logOut(ActionEvent event) {
        try {
            Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLDocumentLogin.fxml"));
            Scene home_scene = new Scene(home_parent);
            Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            home_stage.setScene(home_scene);
            home_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBrowse.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TODO: track currentUser while navigating
    }

    private void viewAdminSettings(ActionEvent event) {
        try {
            Parent home_parent = FXMLLoader.load(getClass().getResource("FXMLDocumentAdmin.fxml"));
            Scene home_scene = new Scene(home_parent);
            Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            home_stage.setScene(home_scene);
            home_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerBrowse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
