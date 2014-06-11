/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;

/**
 *
 * @author Krzysztof
 */
public class QuestionProposition implements Serializable {

    private final QuestionEntity proposedQuestion;
    private final String userLogin;
    private final long testID;

    public QuestionProposition(QuestionEntity proposedQuestion, String userLogin, long testID) {
        this.proposedQuestion = proposedQuestion;
        this.userLogin = userLogin;
        this.testID = testID;
    }

    public QuestionEntity getProposedQuestion() {
        return proposedQuestion;
    }

    public String getUserLogin() {
        return userLogin;
    }

}
