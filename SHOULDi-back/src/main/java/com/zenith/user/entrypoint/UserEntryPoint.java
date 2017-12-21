/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.user.entrypoint;

import com.user.service.implementation.UserServiceImpl;
import com.zenith.Beans.UserBean;
import com.zenith.request.model.UserSignUpModel;
import com.zenith.user.service.Interface.UserService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.BeanUtils;

/**
 * This will be our resource class, it will accept an
 * HTTP request and return an HTTP response
 * 
 */
@Path("/users") // you need a path annotation to make a class a resource class
public class UserEntryPoint {
    
    /*
    * When an http request arrives at this path, and it is a post
    * request, this method will be called. The request will contain
    * JSON data. This method will accept this information and convert it 
    * into a java object (using a framework to do this conversion). Upon 
    * completion this method will convert the CreateUserResponseModel POJO
    * back into JSON that can be read by our front-end
    */
    @POST 
    @Consumes(MediaType.APPLICATION_JSON) // our method consumes or takes in json data
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML }) // our method produces json data to send back to angular
    public UserBean createUser(UserSignUpModel requestObject){
        
      
        
       
        
        // create new user
        UserService userService = new UserServiceImpl(); 
        UserBean createdUserProfile = userService.createUser(requestObject); 
        
        
        //prepare response 
        //BeanUtils.copyProperties(createdUserProfile, returnValue);
        
        /* return use data to client */ 
        return createdUserProfile; 
        
    }
    
}
