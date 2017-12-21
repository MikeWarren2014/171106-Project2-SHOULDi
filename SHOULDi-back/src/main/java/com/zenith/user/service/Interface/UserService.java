/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.user.service.Interface;

import com.zenith.Beans.UserBean;
import com.zenith.request.model.UserSignUpModel;

/**
 *
 * @author calebschumake
 */
public interface UserService {
    
    public UserBean createUser(UserSignUpModel requestObject); 
    
}
