/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

/**
 *
 * @author Krzysztof
 */
public class QuestionProposition {

    private final QuestionEntity proposedQuestion;
    private final String userLogin;

    public QuestionProposition(QuestionEntity proposedQuestion, String userLogin) {
        this.proposedQuestion = proposedQuestion;
        this.userLogin = userLogin;
    }

    public QuestionEntity getProposedQuestion() {
        return proposedQuestion;
    }

    public String getUserLogin() {
        return userLogin;
    }

}
