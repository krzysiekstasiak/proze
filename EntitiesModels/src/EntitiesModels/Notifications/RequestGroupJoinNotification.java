/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels.Notifications;

import java.util.Date;

/**
 * Klasa reprezentująca żądanie dołączenia do grupy.
 *
 * @author Krzysztof
 */
public class RequestGroupJoinNotification extends Notification {

    private final String userLogin;
    private final String groupName;

    /**
     * Konstruktor utworzony w celach testowych.
     *
     * @deprecated Do usunięcia z chwilą uruchomienia serwera z bazą danych.
     * @param userLogin Login użytkownika, który chce dołączyć do grupy.
     * @param groupName Nazwa grupy.
     * @param ID Identyfikator powiadomienia.
     * @param notifiedUser Login powiadamianego użytkownika.
     * @param date Data dodania powiadomienia.
     */
    public RequestGroupJoinNotification(String userLogin, String groupName, long ID, String notifiedUser, Date date) {
        super(ID, notifiedUser, date);
        this.userLogin = userLogin;
        this.groupName = groupName;
    }

    /**
     * Zwraca login użytkownika, który chce dołączyć do grupy.
     *
     * @return Login użytkownika.
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * Zwraca nazwę grupy.
     *
     * @return Nazwa grupy.
     */
    public String getGroupName() {
        return groupName;
    }

}
