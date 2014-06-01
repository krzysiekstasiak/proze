/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Klasa modelujące encję testu.
 *
 * @author Krzysztof
 */
public class TestEntity implements Serializable {

    private final long ID;
    private final String name;
    private final Date lastModification;
    private final String groupName;
    private final String authorLogin;
    private final List<QuestionEntity> questions;
    private final boolean editPermitted;

    /**
     * Opis testu.
     */
    protected String description;

    /**
     * Kategoria, do której należy test.
     */
    protected String category;

    /**
     * Konstruktor utworzony w celu testowania GUI. Nie należy tworzyć obiektów
     * tej klasy w kodzie klienta.
     *
     * @deprecated Do ustawiania jako chroniony wraz z uruchomieniem serwera z
     * bazą danych.
     * @param ID Identyfikator testu.
     * @param name Nazwa testu.
     * @param groupName Nazwa grupy, do której należy test.
     * @param lastModification Data ostatniej modyfikacji.
     * @param authorLogin Login autora testu.
     * @param editPermitted Jeśli ustawione jest jako false, próba edycji
     * któregokolwiek pola spowoduje zgłoszenie wyjątku.
     */
    public TestEntity(long ID, String name, String groupName, Date lastModification, String authorLogin, boolean editPermitted) {
        this.ID = ID;
        this.name = name;
        this.groupName = groupName;
        this.editPermitted = editPermitted;
        this.lastModification = lastModification;
        this.authorLogin = authorLogin;
        this.questions = new ArrayList<>();
    }

    /**
     * Zwraca ID testu.
     *
     * @return ID testu.
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
     * Zwraca nazwę grupy, do której należy test.
     *
     * @return Nazwa grupy.
     */
    public String getGroupName() {
        return groupName;
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
     * Zwraca login autora testu.
     *
     * @return Login autora testu.
     */
    public String getAuthorLogin() {
        return authorLogin;
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
     * Modyfikuje opis testu.
     *
     * @param description Nowy opis testu.
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

    /**
     * Zwraca datę ostatniej modyfikacji.
     *
     * @return Data ostatniej modyfikacji.
     */
    public Date getLastModification() {
        return lastModification;
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
     * Modyfikuje kategorię, do której należy test.
     *
     * @param category Nowa kategoria, do której należeć ma test.
     * @throws IllegalAccessException W przypadku próby modyfikacji obiektu
     * tylko oo odczytu. Należy wywołać metodę
     * {@link #isEditPermitted() isEditPermitted} w celu uniknięcia wyjątku.
     */
    public void setCategory(String category) throws IllegalAccessException {
        if (this.editPermitted) {
            this.category = category;
        } else {
            throw new IllegalAccessException("No edit permissions.");
        }
    }

    /**
     * Zwraca listę pytań w teście.
     *
     * @return Niemodyfikowalna lista pytań.
     */
    public List<QuestionEntity> getQuestions() {
        return Collections.unmodifiableList(this.questions);
    }

    /**
     * Dodaje pytanie do testu.
     *
     * @param question Nowe pytanie.
     * @throws IllegalAccessException W przypadku próby modyfikacji obiektu
     * tylko oo odczytu. Należy wywołać metodę
     * {@link #isEditPermitted() isEditPermitted} w celu uniknięcia wyjątku.
     */
    public void addQuestion(QuestionEntity question) throws IllegalAccessException {
        if (this.editPermitted) {
            this.questions.add(question);
        } else {
            throw new IllegalAccessException("No edit permissions.");
        }
    }

    /**
     * Zastępuje podane pytanie w teście nowym.
     *
     * @param oldQuestion Stare pytanie.
     * @param newQuestion Nowe pytanie.
     * @throws IllegalAccessException W przypadku próby modyfikacji obiektu
     * tylko oo odczytu. Należy wywołać metodę
     * {@link #isEditPermitted() isEditPermitted} w celu uniknięcia wyjątku.
     */
    public void replaceQuestion(QuestionEntity oldQuestion, QuestionEntity newQuestion) throws IllegalAccessException {
        if (!this.editPermitted) {
            throw new IllegalAccessException("No edit permissions.");
        }
        if (this.questions.contains(oldQuestion)) {
            this.questions.set(this.questions.indexOf(oldQuestion), newQuestion);
        } else {
            throw new NoSuchElementException("No such question in test.");
        }
    }

    /**
     * Usuwa pytanie z testu.
     *
     * @param question Pytanie do usunięcia.
     * @throws IllegalAccessException W przypadku próby modyfikacji obiektu
     * tylko oo odczytu. Należy wywołać metodę
     * {@link #isEditPermitted() isEditPermitted} w celu uniknięcia wyjątku.
     */
    public void removeQuestion(QuestionEntity question) throws IllegalAccessException {
        if (!this.editPermitted) {
            throw new IllegalAccessException("No edit permissions.");
        }
        if (this.questions.contains(question)) {
            this.questions.remove(question);
        } else {
            throw new NoSuchElementException("No such question in test.");
        }
    }
}
