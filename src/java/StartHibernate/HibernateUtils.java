/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartHibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    
    private static SessionFactory sessionFactory; 
    
    public HibernateUtils() {
        
         Configuration conf = new Configuration(); 
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            
        } catch (HibernateException e) {
            System.err.println("Initial SessionFactory creation failed" + e);
            throw new ExceptionInInitializerError(e); 
        }
        
        
    }
       
 
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory; 
    }
    
    
}