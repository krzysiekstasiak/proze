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
    private final boolean editPermitted;

    /**
     * Imię użytkownika.
     */
    protected String firstName;

    /**
     * Nazwisko użytkownika.
     */
    protected String secondName;

    /**
     * Adres e-mail użytkownika.
     */
    protected String mailAddress;

    /**
     * Konstruktor utworzony w celu testowania GUI. Nie należy tworzyć obiektów
     * tej klasy w kodzie klienta.
     *
     * @param login Login, który zarazem identyfikuje użytkownika.
     * @param editPermitted Jeśli ustawione jest jako false, próba edycji
     * któregokolwiek pola spowoduje zgłoszenie wyjątku.
     */
    public UserEntity(String login, boolean editPermitted) {
        this.login = login;
        this.editPermitted = editPermitted;
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
     */
    public void setFirstName(String firstName) {
        
            this.firstName = firstName;
         
    }

    /**
     * Zwraca nazwisko użytkownika.
     *
     * @return Nazwysko użytkownika.
     */
    public String getLastName() {
        return secondName;
    }

    /**
     * Modyfikuje nazwisko użytkownika.
     *
     * @param secondName Nowe nazwisko.
     */
    public void setSecondName(String secondName) {
      
            this.secondName = secondName;
        
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
     */
    public void setMailAddress(String mailAddress) {
  
            this.mailAddress = mailAddress;
        
    }
}
