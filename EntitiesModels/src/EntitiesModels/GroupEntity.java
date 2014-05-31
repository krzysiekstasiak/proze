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
    private String description;

    /**
     * Konstruktor utworzony w celu testowania GUI. Nie należy tworzyć obiektów
     * tej klasy w kodzie klienta.
     *
     * @deprecated Do ustawiania jako chroniony wraz z uruchomieniem serwera z
     * bazą danych.
     * @param name Nazwa grupy.
     * @param editPermissions Jeśli ustawione jest jako false, próba edycji
     * któregokolwiek pola spowoduje zgłoszenie wyjątku.
     */
    public GroupEntity(String name, boolean editPermissions) {
        this.name = name;
        this.editPermitted = editPermissions;
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
     * @throws IllegalAccessException W przypadku próby modyfikacji obiektu
     * tylko oo odczytu. Należy wywołać metodę
     * {@link #isEditPermitted() isEditPermitted} w celu uniknięcia wyjątku.
     */
    public void setDescription(String description) throws IllegalAccessException {
        if (this.editPermitted) {
            this.description = description;
        } else {
            throw new IllegalAccessException("No edit permissions.");
        }
    }
}
