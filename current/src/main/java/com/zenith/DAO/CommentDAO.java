/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.zenith.Beans.CommentBean;
import com.zenith.Beans.UserBean;
import com.zenith.hibernate.utils.HibernateUtils;
import com.zenith.interfaces.DAO;
import com.zenith.request.model.CommentModel;
import com.zenith.request.model.UserGetModel;
import com.zenith.templates.CommentTemplate;

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
    public List<CommentTemplate> getFlaggedComments(UserGetModel user) {
        session.beginTransaction();
        Criteria criteria;
		
		List<CommentBean> flagged=session.createCriteria(CommentBean.class).list();
		List<CommentTemplate> comments= new ArrayList<CommentTemplate>();
		flagged= session.createCriteria(CommentBean.class).add(Restrictions.eq("isFlagged", 1)).list();
		for(CommentBean comment: flagged)
		{
			if(comment.getCommentor().getUser_id()==user.getUser()) {
				comments.add(new CommentTemplate(comment.getCommentor().getUser_id(), comment.getPostBean().getPost_id(), comment.getComment_text()));
			}
		}
		return comments;
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

	public CommentBean getCommentById(int id) {
        /* make sure value is not null */
        CommentBean commentBean = null;

        CriteriaBuilder cb = session.getCriteriaBuilder();

        // create criteria against a particular persistent class
        CriteriaQuery<CommentBean> criteria = cb.createQuery(CommentBean.class);

        String hql = "FROM CommentBean E WHERE E.comment_id = " + id;
        Query query = session.createQuery(hql);
        List resultList = query.list();

        if (resultList != null && resultList.size() > 0) {
            commentBean = (CommentBean) resultList.get(0);

        }
        return commentBean;
	}

}
