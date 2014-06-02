/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels.Notifications;

import java.io.Serializable;
import java.util.Date;

/**
 * Abstrakcyjna klasa reprezentująca powiadomienie.
 *
 * @author Krzysztof
 */
public abstract class Notification implements Serializable {

    private final String notifiedUser;
    private final Date date;
    private final long ID;

    /**
     * Konstuktor utworzony w celu testowania GUI.
     *
     * @deprecated Do ustawienia jako chroniony z chwilą uruchomienia bazy
     * danych.
     * @param ID ID powiadomienia.
     * @param notifiedUser Login powiadamianego użytkownika.
     * @param date Data utworzenia powiadomienia.
     */
    public Notification(long ID, String notifiedUser, Date date) {
        this.notifiedUser = notifiedUser;
        this.date = date;
        this.ID = ID;
    }

    /**
     * Pobiera login powiadamianego użytkownika.
     *
     * @return Powiadamiany użytkownik.
     */
    public String getNotifiedUser() {
        return notifiedUser;
    }

    /**
     * Pobiera datę dodania powiadomienia.
     *
     * @return Data dodania powiadomienia.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Pobiera identyfikator powiadomienia.
     *
     * @return ID powiadomienia.
     */
    public long getID() {
        return ID;
    }

}
