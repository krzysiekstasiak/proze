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
     */
    public void setDescription(String description)  {

            this.description = description;
        
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
     * 
     */
    public void setCategory(String category){

            this.category = category;
        
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
     * 
     */
    public void addQuestion(QuestionEntity question){

            this.questions.add(question);
        
    }

    /**
     * Zastępuje podane pytanie w teście nowym.
     *
     * @param oldQuestion Stare pytanie.
     * @param newQuestion Nowe pytanie.

     */
    public void replaceQuestion(QuestionEntity oldQuestion, QuestionEntity newQuestion) {
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
     */
    public void removeQuestion(QuestionEntity question)  {
        if (this.questions.contains(question)) {
            this.questions.remove(question);
        } else {
            throw new NoSuchElementException("No such question in test.");
        }
    }
}
