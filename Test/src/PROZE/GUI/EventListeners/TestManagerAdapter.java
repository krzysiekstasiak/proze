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
public class TestManagerAdapter implements TestManagerListener {

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param testName nie istotny
     * @param groupName nie istotny
     */
    @Override
    public void testCreated(String testName, String groupName) {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param testEntity nie sitotny
     */
    @Override
    public void testSaved(TestEntity testEntity) {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param testEntity nie istotny
     */
    @Override
    public void questionPropositionsNeeded(TestEntity testEntity) {
    }

    /**
     * Metoda zaślepka która nic nie robi.
     * 
     * @param questionProposition nie istotny
     */
    @Override
    public void questionPropositionRemoved(QuestionProposition questionProposition) {
    }

}
