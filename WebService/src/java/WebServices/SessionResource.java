/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import SessionAuthentication.SessionAuthenticationBeanLocal;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Krzysztof
 */
@Path("session")
@RequestScoped
public class SessionResource {

    SessionAuthenticationBeanLocal sessionAuthenticationBean = lookupSessionAuthenticationBeanLocal();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of sessionResource
     */
    public SessionResource() {

    }

    @DELETE
    @Path("/{sessionID}")
    public void closeSession(@PathParam("sessionID") String sessionID) {
        this.sessionAuthenticationBean.closeSession(Long.valueOf(sessionID));
    }

    @GET
    @Produces("text/plain")
    public String getSessionID(@QueryParam("login") String login, @QueryParam("password") String password) {
        String responseString;
        try {
            responseString = String.valueOf(this.sessionAuthenticationBean.createSession(login, password));
        } catch (IllegalAccessException ex) {
            responseString = "Authentication Error";
        }
        return responseString;
    }

    private SessionAuthenticationBeanLocal lookupSessionAuthenticationBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (SessionAuthenticationBeanLocal) c.lookup("java:global/Server/ServerEJB/SessionAuthenticationBean!SessionAuthentication.SessionAuthenticationBeanLocal");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }
}
