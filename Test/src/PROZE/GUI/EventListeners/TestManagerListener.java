/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI.EventListeners;

import EntitiesModels.QuestionProposition;
import EntitiesModels.TestEntity;

/**
 *
 * @author Krzysztof
 */
public interface TestManagerListener {

    /**
     * Tworzy nowy test
     * 
     * @param testName nawa tworzonego testu
     * @param groupName nazwa grupy w której test ma zostac utworzony
     */
    public void testCreated(String testName, String groupName);

    /**
     * Zapisuje zmiany w teście
     * 
     * @param testEntity test w którym zapisywane są zmiany
     */
    public void testSaved(TestEntity testEntity);

    /**
     * Zgłoszenie potrzeby pobrania proponowanych pytań
     * 
     * @param testEntity test krórego propozycje pytań trzeba pobrać
     */
    public void questionPropositionsNeeded(TestEntity testEntity);

    /**
     * Usuwa proponowane pytanie z listy proponowanych pytań
     * 
     * @param questionProposition pytanie które jest usuwane
     */
    public void questionPropositionRemoved(QuestionProposition questionProposition);
}
