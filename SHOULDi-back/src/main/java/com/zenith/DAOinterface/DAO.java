/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.DAOinterface;

import com.zenith.beans.UserBean;

/**
 *
 * @author calebschumake
 */
public interface DAO {
    
    public void openConnection();
    public void closeConnection(); 
    public UserBean getUserByUsername(String username); 
    public UserBean saveUser(UserBean user); 
    
}