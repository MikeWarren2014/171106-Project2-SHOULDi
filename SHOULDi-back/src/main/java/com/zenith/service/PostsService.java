package com.zenith.service;

import java.util.List;

import com.zenith.Beans.PostBean;
import com.zenith.DAO.OracleDB;
import com.zenith.interfaces.DAO;

public class PostsService {
	
    DAO database;

    public PostsService() {
        this.database = new OracleDB();
    }
    
	public List<PostBean> getFlaggedPosts()
	{		
    	try 
    	{
    		this.database.openConnection();
    		return database.getFlaggedPosts();
    	}
    	finally
    	{
    		database.closeConnection();
    	}
	}
}
