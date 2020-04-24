package cis421onlinecatalog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Dominic Santangelo
 */
public class FXMLDocumentControllerBrowse implements Initializable {
    
    @FXML protected TableView productTableView, categoryTableView;
    @FXML private TableColumn<Product, String> nameCol, brandCol, upcCol, categoryCol;
    @FXML private TableColumn<Product, Integer> priceCol, stockCol;
    ObservableList<Product> productList = FXCollections.observableArrayList();
    ObservableList<Product> categoryList = FXCollections.observableArrayList();
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
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

}
