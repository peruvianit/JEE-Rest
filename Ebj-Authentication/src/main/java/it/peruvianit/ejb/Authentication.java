package it.peruvianit.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Authentication
 */
@Stateless
@LocalBean
public class Authentication implements AuthenticationRemote, AuthenticationLocal {
    /**
     * Default constructor. 
     */
    public Authentication() {
        // TODO Auto-generated constructor stub
    }
    
    public String infoEJB(){
    	return "Authentication-EJB";    	
    }
}
