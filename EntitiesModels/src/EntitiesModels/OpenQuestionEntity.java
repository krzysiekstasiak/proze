/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

/**
 * Klasa reprezentująca pytanie otwarte.
 *
 * @author Krzysztof
 */
public class OpenQuestionEntity extends QuestionEntity {

    private String correctAnswer;

    /**
     * Zwraca poprawną odpowiedź na pytanie.
     *
     * @return Poprawna odpowiedź na pytanie.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Modyfikuje poprawną odpowiedź na pytanie.
     *
     * @param correctAnswer Nowa poprawna odpowiedź.
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
