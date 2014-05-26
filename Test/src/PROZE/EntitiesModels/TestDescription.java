/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.EntitiesModels;

import java.util.Date;

/**
 * Opis testu pozwalający na jego identyfikację.
 * @author Krzysztof
 */
public class TestDescription {

    private final String name;
    private final String groupName;
    private final int ID;
    private final String description;
    private final Date added;
    private final String categoryName;
    private final String authorLogin;

    /**
     * Konstruktor klasy
     *
     * @param name Nazwa testu
     * @param groupName Nazwa grupy, do której należy test
     * @param ID Identyfikator testu
     * @param description Opis testu
     * @param added Data dodania testu
     * @param categoryName Nazwa kategorii
     * @param authorLogin Login autora
     */
    public TestDescription(String name, String groupName, int ID, String description, Date added, String categoryName, String authorLogin) {
        this.name = name;
        this.groupName = groupName;
        this.ID = ID;
        this.description = description;
        this.added = added;
        this.categoryName = categoryName;
        this.authorLogin = authorLogin;
    }

    /**
     * Pobiera nazwę testu.
     *
     * @return Nazwa testu
     */
    public String getName() {
        return name;
    }

    /**
     * Pobiera nazwę grupy.
     *
     * @return Nazwa grupy, do której należy test
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Pobiera identyfikator testu.
     *
     * @return Identyfikator tesstu
     */
    public int getID() {
        return ID;
    }

    /**
     * Pobiera opis testu.
     *
     * @return Opis testu
     */
    public String getDescription() {
        return description;
    }

    /**
     * Pobiera datę dodania testu.
     *
     * @return Data dodania testu.\
     */
    public Date getAdded() {
        return added;
    }

    /**
     * Pobiera nazwę kategorii.
     *
     * @return Nazwa kategorii
     */
    public String getCategoryName() {
        return categoryName;
    }
    
    /**
     * Pobiera login autora.
     * @return Login autora
     */
    public String getAuthorLogin() {
        return authorLogin;
    }
  
    
}
