package cis421onlinecatalog;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.stage.Stage;

/**
 *
 * @author Dominic Santangelo
 */
public class FXMLDocumentControllerAdmin implements Initializable {
    
    @FXML private Label label;
    @FXML protected TableView productTableView;
    @FXML private TableColumn<Product, String> nameCol, brandCol, upcCol, categoryCol;
    @FXML private TableColumn<Product, Integer> priceCol, stockCol;
    @FXML private Button addButton, removeButton, editButton, quitButton;
    ObservableList<Product> productList = FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == addButton) {
            addRow();
        }
        else if (event.getSource() == removeButton) {
            removeRow();
        }
        else if (event.getSource() == editButton) {
            editRow();
        }
        else if (event.getSource() == quitButton) {
            quit(event);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            initList();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty()); //setting the columns for the tableview
        brandCol.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        upcCol.setCellValueFactory(cellData -> cellData.getValue().upcProperty());
        categoryCol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject()); 
        stockCol.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        
        productTableView.setItems(productList);
        
    }    
    private void initList() {
        //TODO: pull data from the database from table PRODUCT to populate productList
        //I recommend saving each tuple from the database to a temporary Product object (see Product.java) and then using "productList.add(tempProduct);"
        
        
        
        //this filler data is just to show that the table works. it should be deleted after implementation
        Product tempProduct = new Product("111111111111", "Straight-up Oil", "Suave", "Bath & Body", 5, 25 );
        productList.add(tempProduct);
        
        //conn.close();
    }
    
    private void addRow()  {
        //TODO: allows user to add rows in the table and then save the changes to the database.
        CIS421OnlineCatalog add = new CIS421OnlineCatalog();
        try {
            add.insertProduct("000", "Name", "20", "Brand", "1", "Category");
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void removeRow()  {
        //TODO: allows user to delete rows in the table and then save the changes to the database
        CIS421OnlineCatalog delete;
        delete = new CIS421OnlineCatalog();
        try {
            delete.deleteProcuct("000");
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void editRow() {
        //TODO: allows user to edit rows in the table and then save them to the database
    }
    
    private void quit(ActionEvent event) {
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
}
