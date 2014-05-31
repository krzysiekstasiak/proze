/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;

/**
 * Model encji użytkownika.
 *
 * @author Krzysztof
 */
public class UserEntity implements Serializable {

    private final String login;
    private String firstName;
    private String secondName;
    private String mailAddress;
    private final boolean editPermitted;

    /**
     * Konstruktor utworzony w celu testowania GUI. Nie należy tworzyć obiektów
     * tej klasy w kodzie klienta.
     *
     * @deprecated Do ustawiania jako chroniony wraz z uruchomieniem serwera z
     * bazą danych.
     * @param login Login, który zarazem identyfikuje użytkownika.
     * @param editPermissions Jeśli ustawione jest jako false, próba edycji
     * któregokolwiek pola spowoduje zgłoszenie wyjątku.
     */
    public UserEntity(String login, boolean editPermissions) {
        this.login = login;
        this.editPermitted = editPermissions;
    }

    /**
     * Sprawdza, czy obiekt może być modyfikowany.
     *
     * @return True, jeśli istnieje możliwość edycji.
     */
    public boolean isEditPermitted() {
        return this.editPermitted;
    }

    /**
     * Zwraca login użytkownika.
     *
     * @return Login użytkownika.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Zwraca imię użytkownika.
     *
     * @return Imię użytkownika.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Modyfikuje imię użytkownika.
     *
     * @param firstName Nowe imię.
     * @throws IllegalAccessException W przypadku próby modyfikacji obiektu
     * tylko oo odczytu. Należy wywołać metodę
     * {@link #isEditPermitted() isEditPermitted} w celu uniknięcia wyjątku.
     */
    public void setFirstName(String firstName) throws IllegalAccessException {
        if (this.editPermitted) {
            this.firstName = firstName;
        } else {
            throw new IllegalAccessException("No edit permissions.");
        }
    }

    /**
     * Zwraca nazwisko użytkownika.
     *
     * @return Nazwysko użytkownika.
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Modyfikuje nazwisko użytkownika.
     *
     * @param secondName Nowe nazwisko.
     * @throws IllegalAccessException W przypadku próby modyfikacji obiektu
     * tylko oo odczytu. Należy wywołać metodę
     * {@link #isEditPermitted() isEditPermitted} w celu uniknięcia wyjątku.
     */
    public void setSecondName(String secondName) throws IllegalAccessException {
        if (this.editPermitted) {
            this.secondName = secondName;
        } else {
            throw new IllegalAccessException("No edit permissions.");
        }
    }

    /**
     * Zwraca adres e-mail użytkownika.
     *
     * @return Adres e-mail użytkownika.
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * Modyfikuje adres e-mail użytkownika.
     *
     * @param mailAddress Nowy adres e-mail.
     * @throws IllegalAccessException W przypadku próby modyfikacji obiektu
     * tylko oo odczytu. Należy wywołać metodę
     * {@link #isEditPermitted() isEditPermitted} w celu uniknięcia wyjątku.
     */
    public void setMailAddress(String mailAddress) throws IllegalAccessException {
        if (this.editPermitted) {
            this.mailAddress = mailAddress;
        } else {
            throw new IllegalAccessException("No edit permissions.");
        }
    }
}
