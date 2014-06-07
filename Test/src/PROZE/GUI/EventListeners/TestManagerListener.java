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

    public void testCreated(String testName, String groupName);

    public void testSaved(TestEntity testEntity);

    public void questionPropositionsNeeded(TestEntity testEntity);

    public void questionPropositionRemoved(QuestionProposition questionProposition);
}
