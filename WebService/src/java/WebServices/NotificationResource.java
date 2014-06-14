/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Auxiliary.SerializerBeanLocal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Krzysztof
 */
@Path("notification/{sessionID}")
@RequestScoped
public class NotificationResource {

    @EJB
    SerializerBeanLocal serializerBean;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NotificationResource
     */
    public NotificationResource() {
    }

    /**
     * Retrieves representation of an instance of
     * WebServices.NotificationResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public byte[] getNotifications(@PathParam("sessionID") String sessionID) {
        return null;
    }

}
