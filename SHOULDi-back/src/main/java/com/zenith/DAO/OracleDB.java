/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.util.HibernateUtil;
import com.zenith.Beans.PostBean;
import com.zenith.Beans.UserBean;
import com.zenith.hibernate.utils.HibernateUtils;
import com.zenith.interfaces.DAO;

/**
 *
 * @author calebschumake
 */
public class OracleDB implements DAO {
    
	Session session= HibernateUtil.getSession();

    

    public void openConnection() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public void closeConnection() {
        if (session != null) {
            session.close();
        }
    }

    public UserBean getUserByUsername(String username) {
        
        /* make sure value is not null */
        if (username == null || username.isEmpty()) {
            return null;
        }

        UserBean userBean = null;

        CriteriaBuilder cb = session.getCriteriaBuilder();

        //create criteria against a particular persistent class
        CriteriaQuery<UserBean> criteria = cb.createQuery(UserBean.class);
        
        String hql = "FROM User E WHERE E.email = " + username;
        Query query = session.createQuery(hql);
        List resultList = query.list();
//
//        // query roots always reference entity
//        Root<UserBean> profileRoot = criteria.from(UserBean.class);
//        criteria.select(profileRoot);
//        criteria.where(cb.equal(profileRoot.get("email"), username));
//
//        // fetch single result
//        Query<UserBean> query = session.createQuery(criteria);
//        List<UserBean> resultList = query.getResultList();
        if (resultList != null && resultList.size() > 0) {
            userBean = (UserBean) resultList.get(0);
            
        }

        return userBean;
    }

    public void saveUser(UserBean user) {

        session.beginTransaction();
        session.save(user); 
        session.getTransaction().commit(); 
                
    }
    
    public List<UserBean> getFavoriteUsers() {

        session.beginTransaction();
        Criteria criteria;
		
		List<UserBean> favorites=session.createCriteria(UserBean.class).list();
		
		favorites= session.createCriteria(UserBean.class).add(Restrictions.gt("score", 2000)).list();
		return favorites;
                
    }
    
    public List<PostBean> getFlaggedPosts(){
    	
        session.beginTransaction();
        Criteria criteria;
		
		List<PostBean> flagged=session.createCriteria(PostBean.class).list();
		
		flagged= session.createCriteria(PostBean.class).add(Restrictions.eq("flagged", 1)).list();
		return flagged;
    }
    
    public void test() {
    	Transaction tx= session.beginTransaction(); 
    	UserBean test= new UserBean();
    	session.save(test);
    	tx.commit();
    }
    
}
