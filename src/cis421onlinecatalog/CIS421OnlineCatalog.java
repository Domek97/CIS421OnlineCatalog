/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis421onlinecatalog;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Dominic Santangelo
 */
public class CIS421OnlineCatalog extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentLogin.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Optimum Merchant");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("optimummerchantlogo.png")));
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection con = DriverManager.getConnection(connectionUrl);  
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
