/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;
import java.util.Date;

/**
 * Klasa służąca do przechowywania informacji o teście bez potrzeby pobierania
 * wszystkich pytań.
 *
 * @author Krzysztof
 */
public class TestDescription implements Serializable {

    private final long ID;
    private final String name;
    private final Date lastModification;
    private final String groupName;
    private final String authorLogin;
    private final String category;
    private final String description;
    private final int rating;
    private final boolean editable;

    /**
     * Konstruktor utworzony w celu testowania GUI. Nie należy tworzyć obiektów
     * tej klasy w kodzie klienta.
     *
     * @deprecated Do ustawiania jako chroniony wraz z uruchomieniem serwera z
     * bazą danych.
     * @param ID Identyfikator testu.
     * @param name Nazwa testu.
     * @param lastModification Data ostatniej modyfikacji.
     * @param groupName Nazwa grupy, do której należy test.
     * @param authorLogin Login autora testu.
     * @param category Kategoria, do której należy test.
     * @param description Opis testu.
     * @param rating Ocena testu (zapisana zostanie w skali od 1 do 10).
     */
    public TestDescription(long ID, String name, Date lastModification, String groupName, String authorLogin, String category, String description, int rating, boolean editable) {
        this.ID = ID;
        this.name = name;
        this.lastModification = lastModification;
        this.groupName = groupName;
        this.authorLogin = authorLogin;
        this.category = category;
        this.description = description;
        this.rating = ((rating - 1) % 10) + 1;
        this.editable = editable;
    }

    /**
     * Zwraca identyfikator testu.
     *
     * @return Identyfikator testu.
     */
    public long getID() {
        return ID;
    }

    /**
     * Zwraca nazwę testu.
     *
     * @return Nazwa testu.
     */
    public String getName() {
        return name;
    }

    /**
     * Zwraca datę ostatniej modyfikacji testu.
     *
     * @return Data ostatniej modyfikacji.
     */
    public Date getLastModification() {
        return lastModification;
    }

    /**
     * Zwraca nazwę grupy, do której należy test.
     *
     * @return Nazwa grupy, do której należy test.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Zwraca login autora testu.
     *
     * @return Login autora testu.
     */
    public String getAuthorLogin() {
        return authorLogin;
    }

    /**
     * Zwraca kategorię, do której należy test.
     *
     * @return Kategoria, do której należy test.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Zwraca opis testu.
     *
     * @return Opis testu.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Zwraca ocenę testu.
     *
     * @return Ocena testu.
     */
    public int getRating() {
        return rating;
    }

    public boolean isEditable() {
        return editable;
    }

}
