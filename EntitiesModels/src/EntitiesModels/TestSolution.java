/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Krzysztof
 */
public class TestSolution implements Serializable {

    private final Map<QuestionEntity, String> answers = new HashMap<>();
    private final long testID;

    public TestSolution(long testID) {
        this.testID = testID;
    }

    public void addAnswer(QuestionEntity question, String answer) {
        this.answers.put(question, answer);
    }

    public Map<QuestionEntity, String> getAnswers() {
        return Collections.unmodifiableMap(this.answers);
    }

    public long getTestID() {
        return this.testID;
    }
}
