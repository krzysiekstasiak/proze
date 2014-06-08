/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionAuthentication;

import javax.ejb.Singleton;

/**
 *
 * @author Krzysztof
 */
@Singleton
public class SessionAuthenticationBean implements SessionAuthenticationBeanLocal {

    @Override
    public long createSession(String login, String password) throws IllegalAccessException {
        return 0L;
    }

    @Override
    public boolean closeSession(long sessionID) {
        return false;
    }

    @Override
    public String getUserLogin(String sessionID) {
        return null;
    }

}
