/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

/**
 * Model encji grupy.
 *
 * @author Krzysztof
 */
public class GroupEntity {

    private final String name;
    private final boolean editPermitted;
    private String description;

    /**
     * Konstruktor utworzony w celu testowania GUI. Nie należy tworzyć obiektów tej klasy w kodzie klienta.
     * @deprecated Do ustawiania jako chroniony wraz z uruchomieniem serwera z bazą danych. 
     * @param name Nazwa grupy.
     * @param editPermissions Jeśli ustawione jest jako false, próba edycji któregokolwiek pola spowoduje zgłoszenie wyjątku.
     */
    public GroupEntity(String name, boolean editPermissions) {
        this.name = name;
        this.editPermitted = editPermissions;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public boolean isEditPermitted() {
        return editPermitted;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * @throws IllegalAccessException
     */
    public void setDescription(String description) throws IllegalAccessException {
        if (this.editPermitted) {
            this.description = description;
        } else {
            throw new IllegalAccessException("No edit permissions.");
        }
    }
}
