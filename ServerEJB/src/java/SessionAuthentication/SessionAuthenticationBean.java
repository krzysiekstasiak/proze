/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionAuthentication;

import PermissionsValidator.PermissionsValidatorBeanLocal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author Krzysztof
 */
@Singleton
public class SessionAuthenticationBean implements SessionAuthenticationBeanLocal {

    Map<Long, SessionEntry> sessions = new HashMap<>();

    @EJB
    PermissionsValidatorBeanLocal permissionsValidatorBean;

    @Override
    public long createSession(String login, String password) throws IllegalAccessException {
        if (!permissionsValidatorBean.authenticateUser(login, password)) {
            throw new IllegalAccessException("Incorrect username or password");
        }
        SessionEntry sessionEntry = new SessionEntry(login);
        long proposedSessionID;
        Random random = new Random();
        do {
            proposedSessionID = random.nextLong();
        } while (this.sessions.putIfAbsent(proposedSessionID, sessionEntry) != null);
        return proposedSessionID;
    }

    @Override
    public boolean closeSession(long sessionID) {
        if (this.sessions.containsKey(sessionID)) {
            this.sessions.remove(sessionID);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getUserLogin(long sessionID) {

        SessionEntry sessionEntry = this.sessions.get(sessionID);
        sessionEntry.updateLastActivity();
        return sessionEntry.getUserLogin();
    }

    @Schedule(minute = "*/10")
    private void removeOldSessions() {
        this.sessions.forEach(new BiConsumer<Long, SessionEntry>() {

            @Override
            public void accept(Long t, SessionEntry u) {
                if (u.getLastActivity().getTime() < Calendar.getInstance().getTimeInMillis() - 3600000) {
                    sessions.remove(t);
                }
            }
        });
    }

    private static class SessionEntry {

        private final String userLogin;
        private final Date lastActivity;

        public SessionEntry(String login) {
            this.userLogin = login;
            this.lastActivity = new Date();
        }

        public String getUserLogin() {
            return userLogin;
        }

        public Date getLastActivity() {
            return lastActivity;
        }

        public void updateLastActivity() {
            this.lastActivity.setTime(Calendar.getInstance().getTimeInMillis());
        }
    }

}
