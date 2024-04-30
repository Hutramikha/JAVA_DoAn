package DTO;

import java.lang.*;
import java.sql.*;
import javax.swing.*;

public class user {

    protected String username;
    protected String password;
    protected int status;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }

    public user() {
    }

    public user(String username, String password, int status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    @Override
    public String toString() {
        return "user{" + "username=" + username + ", password=" + password + ", status=" + status + '}';
    }
    
}
