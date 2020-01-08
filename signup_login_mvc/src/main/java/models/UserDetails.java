/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author KHATRI
 */
public class UserDetails {
    private String formUsername;
    private String formUserPassword;
    private String dbUsername;
    private String dbUserPassword;

    public UserDetails() {
    }

    public UserDetails(String formUsername, String formUserPassword, String dbUsername, String dbUserPassword) {
        this.formUsername = formUsername;
        this.formUserPassword = formUserPassword;
        this.dbUsername = dbUsername;
        this.dbUserPassword = dbUserPassword;
    }
    
    public boolean passcheck(){
    return formUserPassword.equals(dbUserPassword);
     }
    public boolean usernameCheck(){
    return formUsername.equals(dbUsername);
    }
    
    public void setFormData(String username,String password){
        this.formUsername = username;
        this.formUserPassword = password;
    }
    public void setDbData(String username,String password){
    this.dbUsername = username;
    this.dbUserPassword = password;
    }

}
