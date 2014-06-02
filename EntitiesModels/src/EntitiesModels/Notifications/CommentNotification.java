/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels.Notifications;

import java.util.Date;

/**
 * Klasa reprezentująca powiadomienie o dodaniu komentarza do testu.
 *
 * @author Krzysztof
 */
public class CommentNotification extends Notification {

    private final long commentID;
    private final long testID;

    /**
     * Konstruktor klasy utworzony w celach testów.
     *
     * @deprecated Do ustawienia jako chroniony z chwilą uruchomienia serwera z
     * bazą danych.
     * @param commentID ID komentarza.
     * @param testID ID testu.
     * @param ID ID powiadomienia.
     * @param notifiedUser Login powiadamianego użytkownika
     * @param date Data utworzenia powiadomienia.
     */
    public CommentNotification(long commentID, long testID, long ID, String notifiedUser, Date date) {
        super(ID, notifiedUser, date);
        this.commentID = commentID;
        this.testID = testID;
    }

    /**
     * Zwraca ID komentarza.
     *
     * @return
     */
    public long getCommentID() {
        return commentID;
    }

    /**
     * Zwraca ID testu.
     *
     * @return
     */
    public long getTestID() {
        return testID;
    }

}
