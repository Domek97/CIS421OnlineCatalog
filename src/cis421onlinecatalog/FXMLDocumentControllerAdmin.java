package cis421onlinecatalog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
            quit();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initList();
        
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty()); //setting the columns for the tableview
        brandCol.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        upcCol.setCellValueFactory(cellData -> cellData.getValue().upcProperty()); //setting the columns for the tableview
        categoryCol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject()); //setting the columns for the tableview
        stockCol.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        
        productTableView.setItems(productList);
        
    }    
    private void initList() {
        //TODO: pull data from the database from table PRODUCT to populate Set<Product> productSet
        //I recommend saving each tuple from the database to a temporary Product object (see Product.java) and then using "productList.add(tempProduct);"
        //this filler data is just to show that the table works
        Product tempProduct = new Product("111111111111", "Straight-up Oil", "Suave", "Bath & Body", 5, 25 );
        productList.add(tempProduct);
    }
    
    private void addRow() {
        //TODO: allows user to add rows in the table and then save the changes to the database.
    }
    
    private void removeRow() {
        //TODO: allows user to delete rows in the table and then save the changes to the database
    }
    
    private void editRow() {
        //TODO: allows user to edit rows in the table and then save them to the database
    }
    
    private void quit() {
        //TODO: take the user back to the browse page
    }
}
