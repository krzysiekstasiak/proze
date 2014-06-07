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

    @Override
    public void testCreated(String testName, String groupName) {
    }

    @Override
    public void testSaved(TestEntity testEntity) {
    }

    @Override
    public void questionPropositionsNeeded(TestEntity testEntity) {
    }

    @Override
    public void questionPropositionRemoved(QuestionProposition questionProposition) {
    }

}
