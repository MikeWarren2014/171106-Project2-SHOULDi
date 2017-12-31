/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.DAO;

import com.zenith.Beans.CommentBean;
import com.zenith.Beans.PostBean; 
import com.zenith.Beans.UserBean;
import com.zenith.hibernate.utils.HibernateUtils;
import com.zenith.interfaces.DAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.zenith.hibernate.utils.HibernateUtils;
import com.zenith.request.model.CommentModel;

/**
 *DAO layer to access database in regards to comments
 * @author Xavier Garibay and Caleb Schumake
 */
public class CommentDAO implements DAO {

    Session session = null;

    public void openConnection() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public void closeConnection() {
        if (session != null) {
            session.close();
        }
    }
    /**
     * Get all comments flagged for moderator to review
     */
    public List<CommentBean> getFlaggedComments() {
        session.beginTransaction();
        Criteria criteria;
		
		List<CommentBean> flagged=session.createCriteria(CommentBean.class).list();
		
		flagged= session.createCriteria(CommentBean.class).add(Restrictions.eq("is_flagged", 1)).list();
		return flagged;
    }

    /**
     * Flag a comment and the commentor to be reviewed by moderator
     */
    public boolean flagComment(CommentModel comment) { 
        int comment_id = comment.getCommentID(); 

        /* Get comment based on ID */
        String hql = "From CommentBean E WHERE E.COMMENT_ID = :comment_id";
        List comments
                = session.createQuery(hql).setParameter("comment_id", comment_id)
                        .list();
        if (comments.isEmpty()) {
            return false;
        } else {
            session.beginTransaction(); 
            CommentBean commentToFlag = (CommentBean)comments.get(0); 
            commentToFlag.setIsFlagged(1);
            UserBean user=commentToFlag.getCommentor();
            user.setFlag(1);
            session.update(user);
            session.update(commentToFlag);         
            return true; 
        }

    }

}
