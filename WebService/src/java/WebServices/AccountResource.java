/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Auxiliary.SerializerBeanLocal;
import SessionAuthentication.SessionAuthenticationBeanLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
@Path("account")
@RequestScoped
public class AccountResource {

    @EJB
    SerializerBeanLocal serializerBean;

    @EJB
    SessionAuthenticationBeanLocal sessionAuthenticationBean;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AccountResource
     */
    public AccountResource() {
    }

    /**
     * Retrieves representation of an instance of WebServices.AccountResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] getUserEntity(@QueryParam("sessionID") String sessionID) throws IOException {
        return null;
    }

    /**
     * PUT method for updating or creating an instance of AccountResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] registerUser(@QueryParam("login") String login, @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName, @QueryParam("emailAddress") String emailAddress, @QueryParam("password") String password) {
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void updateAccount(@QueryParam("sessionID") String sessionID, byte[] updatedUserEntity) {

    }
}
