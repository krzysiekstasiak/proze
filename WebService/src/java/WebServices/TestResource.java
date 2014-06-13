/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import SessionAuthentication.SessionAuthenticationBeanLocal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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

    @EJB
    SessionAuthenticationBeanLocal sessionAuthenticationBean;

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
    @Path("/{testID}")
    public byte[] getTest(@PathParam("testID") String name, @PathParam("sessionID") String sessionID) {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of TestResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] createTest(@QueryParam("name") String name, @QueryParam("groupName") String groupName, @PathParam("sessionID") String sessionID) {
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void updateTest(@QueryParam("sessionID") String sessionID, byte[] testEntity) {
    }

    @POST
    @Path("/{testID}/solution")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void sendSolution(@PathParam("testID") String name, @PathParam("sessionID") String sessionID, byte[] sentSolution) {
    }

    @PUT
    @Path("/{testID}/comment")
    @Consumes(MediaType.TEXT_PLAIN)
    public void postComment(@PathParam("testID") String testName, @PathParam("sessionID") String sessionID, String commentContent, @QueryParam("rating") int rating) {
    }

    @GET
    @Path("/{testID}/comment")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] getComments(@PathParam("testID") String testName, @PathParam("sessionID") String sessionID) {
        return null;
    }

    @POST
    @Path("/{testID}/proposition")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void postQuestionProposition(@PathParam("testID") String testID, @PathParam("sessionID") String sessionID, byte[] questionProposition) {
    }

    @GET
    @Path("/{testID}/proposition")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] getQuestionPropositions(@PathParam("testID") String testID, @PathParam("sessionID") String sessionID) {
        return null;
    }

    @POST
    @Path("/{testID}/error")
    public void postQuestionError(@PathParam("testID") String testID, @PathParam("sessionID") String sessionID, @QueryParam("questionIndex") String questionIndex, String problemDescription, @QueryParam("solution") String possibleSolution) {
    }

    @GET
    @Path("/{testID}/error")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] getQuestionErrors(@PathParam("testID") String testID, @PathParam("sessionID") String sessionID) {
        return null;
    }

    @GET
    @Path("/{testID}/date")
    @Produces(MediaType.TEXT_PLAIN)
    public String getModificationDate(@PathParam("testID") String testID, @PathParam("sessionID") String sessionID) {
        return null;
    }

}
