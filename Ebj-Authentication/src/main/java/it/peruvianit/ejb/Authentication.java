package it.peruvianit.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.peruvianit.authenticator.BasicForm;
import it.peruvianit.authenticator.LDap;
import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.TokenUtils;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.interfaces.SecurityAuthenticator;
import it.peruvianit.invoke.Authenticator;

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
    
    public boolean doLogin(AccountDto accountDto){
    	SecurityAuthenticator securityAuthenticator = null;
    	
    	switch (accountDto.getTypeAccessAccount()) {
			case BASIC_FORM:
				securityAuthenticator = new BasicForm(accountDto);
				break;
			case LDAP:
				securityAuthenticator = new LDap(accountDto);
				break;	
			default:
				break;
		}
    	
    	return Authenticator.doLogin(securityAuthenticator);
    }
    
    public TokenTransfer generateToken(UserDetails userDetails){    	
    	return new TokenTransfer(TokenUtils.createToken(userDetails));
    }
    
    public String infoEJB(){    	
    	return "Authentication-EJB";    	
    }
}
