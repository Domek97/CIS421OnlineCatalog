/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis421onlinecatalog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.*;
import java.util.Calendar;
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
        Connection conn = DriverManager.getConnection(connectionUrl);  
        
        

        stage.setScene(scene);
        stage.show();
        
        
        conn.close();
        
    }
    
    /**
     *
     */
    public void insertUser(String EmailAddress, String Username, String Password) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection conn = DriverManager.getConnection(connectionUrl); 
        
        String query = " insert into USERS (EmailAddress, Username, Password)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        
        stmt.setString(1, EmailAddress);
        stmt.setString(2, Username);
        stmt.setString(3, Password);
        
        stmt.executeQuery(query);
        
        conn.close();
    }
    
    public void deleteUser(String EmailAddress) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection conn = DriverManager.getConnection(connectionUrl); 
        
        
        String query = "delete from USERS where EmailAddress=" + EmailAddress;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate(query);
        System.out.println("Record deleted");
        
        conn.close();
    }
    
    public void insertProduct(String UPC, String Name, String Price, String Brand, String Stock, String Category) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection conn = DriverManager.getConnection(connectionUrl); 
        
        String query = " insert into PRODUCT (UPC, Name, Price, Brand, Stock, Category)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        
        stmt.setString(1, UPC);
        stmt.setString(2, Name);
        stmt.setString(3, Price);
        stmt.setString(4, Brand);
        stmt.setString(5, Stock);
        stmt.setString(6, Category);
        
        
        
        conn.close();
    }
    
    public void deleteProcuct(String UPC) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection conn = DriverManager.getConnection(connectionUrl); 
        
        String query = "delete from PRODUCT where UPC=" + UPC;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate(query);
        System.out.println("Record deleted");
        
        conn.close();
    }
    
    public void insertCart(String UPC, String Quantity, String EmailAddress) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection conn = DriverManager.getConnection(connectionUrl); 
        
        String query = " insert into PRODUCT (UPC, Quantity, EmailAddress)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        
        stmt.setString(1, UPC);
        stmt.setString(2, Quantity);
        stmt.setString(3, EmailAddress);
        
        conn.close();
    }
    
    public void deleteCart(String UPC) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection conn = DriverManager.getConnection(connectionUrl); 
        
        String query = "delete from CART where UPC=" + UPC;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate(query);
        System.out.println("Record deleted");
        
        conn.close();
    }
    
    public void insertAddress(String EmailAddress, String Street, String City, String State, String AptSuite, String Zipcode) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection conn = DriverManager.getConnection(connectionUrl); 
        
        String query = " insert into USERS (EmailAddress, Street, City, State, AptSuite, Zipcode)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        
        stmt.setString(1, EmailAddress);
        stmt.setString(2, Street);
        stmt.setString(3, City);
        stmt.setString(4, State);
        stmt.setString(5, AptSuite);
        stmt.setString(6, Zipcode);
        
        conn.close();
    }
    
    public void deleteAddress(String EmailAddress) throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
            "databaseName=onlineCatalog;integratedsecurity = true"; 
        Connection conn = DriverManager.getConnection(connectionUrl); 
        
        String query = "delete from ADDRESS where EmailAddress=" + EmailAddress;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate(query);
        System.out.println("Record deleted");
        
        conn.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
        
        
        
    }
    
}
