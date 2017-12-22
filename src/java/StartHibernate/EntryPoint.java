/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartHibernate;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author calebschumake
 */

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON) // our method consumes or takes in json data
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

public class EntryPoint {
    
    @POST 
    public void startHibernate() {
        HibernateUtils util = new HibernateUtils();  
    }
    
    
    
}
