/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.service.implementation;

import com.zenith.DAO.Interface.DAO;
import com.zenith.Beans.UserBean;
import com.zenith.com.DAO.Implementation.OracleDB;
import com.zenith.exceptions.RecordAlreadyExistsException;
import com.zenith.request.model.UserSignUpModel;
import com.zenith.user.response.ErrorMessages;
import com.zenith.user.service.Interface.UserService;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author calebschumake
 */
public class UserServiceImpl implements UserService {
    
    DAO database;

    public UserServiceImpl() {
        this.database = new OracleDB();
    }
    
    /**
     * UserSignUpModel is an object that represents the users sign-up information
     * If the user does not already exist, this object must be converted
     * to the Persistent class UserBean and then persisted
     * @param requestObject
     * @return UserBean
     */
    public UserBean createUser(UserSignUpModel requestObject) {
        UserBean userBean = new UserBean(); 
        
        /* Check if user already exits */ 
        UserBean existingUser = this.getUserByEmail(requestObject.getEmail());
        
        if(existingUser != null) {
            throw new RecordAlreadyExistsException(ErrorMessages.RECORD_ALREADY_EXISTS.name()); 
        } 
        
        /* Convert the user request into a persistent Object */ 
        BeanUtils.copyProperties(requestObject, userBean);
        
         /* Save user in database */ 
         saveUser(userBean); 
         
        /* return information back to client */ 
        return userBean;
    }
    
    
        private UserBean getUserByEmail(String email) {
        
        UserBean userBean = null; 
        if(email == null || email.isEmpty()){
            return userBean; 
        }
        
        try {
            this.database.openConnection();
            userBean = this.database.getUserByUsername(email);
        } finally {
            this.database.closeConnection();
        }
        return userBean;
    }
    
    private void saveUser(UserBean user) {
        
        try {
            this.database.openConnection();
            this.database.saveUser(user);
        } finally {
            this.database.closeConnection();
        }
        
    }
    
}
