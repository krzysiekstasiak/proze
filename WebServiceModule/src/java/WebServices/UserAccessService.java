/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebServices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Krzysztof
 */
@WebService(serviceName = "UserAccessService")
@Stateless()
public class UserAccessService {

    /**
     * This is a sample web service operation
     */
    
    private int i=0;
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !" + i++;
    }
}
