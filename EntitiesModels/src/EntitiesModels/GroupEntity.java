/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;

/**
 * Model encji grupy.
 *
 * @author Krzysztof
 */
public class GroupEntity implements Serializable {

    private final String name;
    private final boolean editPermitted;

    /**
     * Opis testu.
     */
    protected String description;

    /**
     * Konstruktor utworzony w celu testowania GUI. Nie należy tworzyć obiektów
     * tej klasy w kodzie klienta.
     *
     * @param name Nazwa grupy.
     * @param editPermitted Jeśli ustawione jest jako false, próba edycji
     * któregokolwiek pola spowoduje zgłoszenie wyjątku.
     */
    public GroupEntity(String name, boolean editPermitted) {
        this.name = name;
        this.editPermitted = editPermitted;
    }

    /**
     * Zwraca nazwę grupy.
     *
     * @return Nazwa grupy.
     */
    public String getName() {
        return name;
    }

    /**
     * Sprawdza, czy obiekt może być modyfikowany.
     *
     * @return True, jeśli istnieje możliwość edycji.
     */
    public boolean isEditPermitted() {
        return editPermitted;
    }

    /**
     * Zwraca opis grupy.
     *
     * @return Opis grupy.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modyfikuje opis grupy.
     *
     * @param description Nowy opis grupy.
     */
    public void setDescription(String description) {

            this.description = description;
        
    }
}
