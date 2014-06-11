/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Auxiliary.SerializerBeanLocal;
import EntitiesModels.GroupEntity;
import SessionAuthentication.SessionAuthenticationBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
@Path("group/{sessionID}")
@RequestScoped
public class GroupResource {

    @EJB
    SerializerBeanLocal serializerBean;

    SessionAuthenticationBeanLocal sessionAuthenticationBean = lookupSessionAuthenticationBeanLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GroupResource
     */
    public GroupResource() {
    }

    /**
     * Retrieves representation of an instance of WebServices.GroupResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/{name}")
    public byte[] getGroupEntity(@PathParam("sessionID") String sessionID, @PathParam("name") String name) {
        GroupEntity group = new GroupEntity(name, true);
        return this.serializerBean.serializeObject(group);
    }

    /**
     * PUT method for updating or creating an instance of GroupResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] createGroup(@QueryParam("name") String name, @PathParam("sessionID") String sessionID) {
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public void updateGroup(byte[] updatedGroup, @QueryParam("sesisonID") String sessionID) {
    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/{name}/members")
    public byte[] getMembers(@PathParam("sessionID") String sessionID, @PathParam("name") String groupName) {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/{name}/tests")
    public byte[] getTests(@PathParam("sessionID") String sessionID, @PathParam("name") String groupName) {
        throw new UnsupportedOperationException("Not implemented yet.");
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
