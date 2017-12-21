/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.DAO.Interface;

import com.zenith.Beans.UserBean;

/**
 *
 * @author calebschumake
 */
public interface DAO {
    
    public void openConnection();
    public void closeConnection(); 
    public UserBean getUserByUsername(String username); 
    public void saveUser(UserBean user); 
    
}