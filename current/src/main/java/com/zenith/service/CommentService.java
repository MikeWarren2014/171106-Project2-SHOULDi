package com.zenith.service;

import java.util.List;

import com.zenith.DAO.CommentDAO;
import com.zenith.request.model.CommentModel;
import com.zenith.request.model.UserGetModel;
import com.zenith.templates.CommentTemplate;
/**
 * Service layer of comment functions that connects dao to entrypoints
 * @author Caleb Schumake and Xavier Garibay
 *
 */
public class CommentService {

    CommentDAO database;

    public CommentService() {
        this.database = new CommentDAO();
    }

    public List<CommentTemplate> getFlaggedComments(UserGetModel user) {
        try {
            this.database.openConnection();
            return database.getFlaggedComments(user);
        } finally {
            database.closeConnection();
        }
    }
    
    public boolean flagComment(CommentModel commentModel){
        try {
            this.database.openConnection();
            return database.flagComment(commentModel); 
        } finally {
            database.closeConnection();
        }
    }

}
