package it.peruvianit.web.resource.base;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AbstractResource {
	private static final String ORG_JBOSS_EJB_CLIENT_NAMING = "org.jboss.ejb.client.naming";

	@SuppressWarnings("unchecked")
	protected <I extends Object> I lookup(	final String jndi,
											final Class<I> interfaceClass) throws NamingException {

		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, ORG_JBOSS_EJB_CLIENT_NAMING);
		final Context context = new InitialContext(jndiProperties);

		return (I) context.lookup(jndi);
	}

}
