/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import SessionAuthentication.SessionAuthenticationBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Krzysztof
 */
@Path("test/{sessionID}")
@RequestScoped
public class TestResource {

    SessionAuthenticationBeanLocal sessionAuthenticationBean = lookupSessionAuthenticationBeanLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TestResource
     */
    public TestResource() {
    }

    /**
     * Retrieves representation of an instance of WebServices.TestResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/{name}")
    public byte[] getTest(@PathParam("name") String name, @PathParam("sessionID") String sessionID) {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of TestResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] createTest(@QueryParam("name") String name, @PathParam("sessionID") String sessionID) {
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void updateTest(@QueryParam("sessionID") String sessionID, byte[] testEntity) {
    }

    @POST
    @Path("/{name}/solution")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void sendSolution(@PathParam("name") String name, @PathParam("sessionID") String sessionID, byte[] sentSolution) {
    }

    @POST
    @Path("/{name}/comment")
    @Consumes(MediaType.TEXT_PLAIN)
    public void postComment(@PathParam("name") String testName, @PathParam("sessionID") String sessionID, String commentContent, @QueryParam("rating") int rating) {
    }

    @GET
    @Path("/{name}/comment")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] getComments(@PathParam("name") String testName, @PathParam("sessionID") String sessionID) {
        return null;
    }

    @POST
    @Path("/{name}/proposition")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void postQuestionProposition(@PathParam("name") String name, @PathParam("sessionID") String sessionID, byte[] question) {
    }

    @GET
    @Path("/{name}/proposition")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] getQuestionPropositions(@PathParam("name") String name, @PathParam("sessionID") String sessionID) {
        return null;
    }

    @POST
    @Path("/{name}/error")
    public void postQuestionError(@PathParam("name") String name, @PathParam("sessionID") String sessionID, @QueryParam("questionIndex") String questionIndex, @QueryParam("problem") String problemDescription, @QueryParam("solution") String possibleSolution) {
    }

    @GET
    @Path("/{name}/error")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] getQuestionErrors(@PathParam("name") String name, @PathParam("session") String sessionID) {
        return null;
    }

    private SessionAuthenticationBeanLocal lookupSessionAuthenticationBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (SessionAuthenticationBeanLocal) c.lookup("java:global/Server/ServerEJB/SessionAuthenticationBean!SessionAuthentication.SessionAuthenticationBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
