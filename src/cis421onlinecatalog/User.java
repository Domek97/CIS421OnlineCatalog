package cis421onlinecatalog;

/**
 *
 * @author Dominic Santangelo
 */
public class User {
    boolean adminAccess;
    String emailAddress, username;
    
    User(String emailAddress, String username) {
        this.adminAccess = false;
        this.emailAddress = emailAddress;
        this.username = username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
}
