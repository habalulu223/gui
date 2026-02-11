/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author USER4
 */
public class Session {

    // 1. THE SINGLE INSTANCE (Singleton Pattern)
    private static Session instance;

    // 2. PRIVATE DATA (User Details)
    private int id;
    private String email;
    private String username;
    private String role;
    private String status;

    // 3. PRIVATE CONSTRUCTOR (Prevents creating new instances from outside)
    private Session() {
    }

    // 4. GLOBAL ACCESS POINT
    public static synchronized Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // 5. GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return role;
    }

    public void setType(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // 6. LOGOUT METHOD (Clears the data)
    public void logout() {
        id = 0;
        email = null;
        username = null;
        role = null;
        status = null;
    }
}