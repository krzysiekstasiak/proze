/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionAuthentication;

import javax.ejb.Local;

/**
 *
 * @author Krzysztof
 */
@Local
public interface SessionAuthenticationBeanLocal {

    long createSession(String login, String password) throws IllegalAccessException;

    boolean closeSession(long sessionID);

    String getUserLogin(String sessionID);

}
