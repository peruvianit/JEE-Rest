package it.peruvianit.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.TokenUtils;
import it.peruvianit.commons.util.token.UserDetails;

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
    
    public TokenTransfer generateToken(UserDetails userDetails){
    	return new TokenTransfer(TokenUtils.createToken(userDetails));
    }
    
    public String infoEJB(){
    	
    	return "Authentication-EJB";    	
    }
}
