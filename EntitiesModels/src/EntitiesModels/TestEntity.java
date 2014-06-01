/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.util.Date;

/**
 *
 * @author Krzysztof
 */
public class TestEntity {

    private final long ID;
    private final String name;
    private String description;
    private Date lastModification;
    private final String groupName;
    private String category;

    public TestEntity(long ID, String name, String groupName) {
        this.ID = ID;
        this.name = name;
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        if (lastModification.compareTo(this.lastModification) > 0) {
            this.lastModification = lastModification;
        } else {
            throw new IllegalArgumentException("Cannot set earlier modification date.");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
