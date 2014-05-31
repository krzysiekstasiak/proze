/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;

/**
 * Klasa reprezentująca komentarz do testu.
 *
 * @author Krzysztof
 */
public class Comment implements Serializable {

    private final long ID;
    private final long testID;
    private final String content;
    private final int rating;

    /**
     * Konstruktor utworzony w celu testowania GUI. Nie należy tworzyć obiektów
     * tej klasy w kodzie klienta.
     *
     * @deprecated Do ustawiania jako chroniony wraz z uruchomieniem serwera z
     * bazą danych.
     * @param ID ID komentarza.
     * @param testID ID testu.
     * @param content Treść komentarza.
     * @param rating Ocena (zapisana zostanie w skali 1 do 10).
     */
    public Comment(long ID, long testID, String content, int rating) {
        this.ID = ID;
        this.testID = testID;
        this.content = content;
        this.rating = (rating % 10) + 1;
    }

    /**
     * Zwraca ID komentarza.
     *
     * @return ID komentarza.
     */
    public long getID() {
        return ID;
    }

    /**
     * Zwraca ID testu, do którego odnosi się komentarz.
     *
     * @return ID testu.
     */
    public long getTestID() {
        return testID;
    }

    /**
     * Zwraca treść komentarza.
     *
     * @return Treść komentarza.
     */
    public String getContent() {
        return content;
    }

    /**
     * Zwraca ocenę.
     *
     * @return Ocena testu.
     */
    public int getRating() {
        return rating;
    }
}
