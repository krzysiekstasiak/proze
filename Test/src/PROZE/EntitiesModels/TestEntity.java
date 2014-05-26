/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PROZE.EntitiesModels;

import PROZE.InputOutput.EntitiesStoringManager;
import java.util.Date;
import java.util.Observable;

/**
 * Klasa reprezentujące test (trzeba dodać możliwość edycji pytań).
 * @author Krzysztof
 */
public class TestEntity extends Observable {
    private final EntitiesStoringManager entitiesStoringManager;
    private final String name;
    private final String groupName;
    private final int ID;
    private String description;
    private final Date added;
    private String categoryName;
    private final String authorLogin;
    
    public TestEntity(EntitiesStoringManager entitiesStoringManager, String name, String groupName, int ID, Date added, String authorLogin) {
        this.entitiesStoringManager = entitiesStoringManager;
        this.name = name;
        this.groupName = groupName;
        this.ID = ID;
        this.added = added;
        this.authorLogin = authorLogin;
    }
    
    public void saveChanges() {
        this.notifyObservers();
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.setChanged();
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.setChanged();
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getID() {
        return ID;
    }

    public Date getAdded() {
        return added;
    }

    public String getAuthorLogin() {
        return authorLogin;
    }
    
}
