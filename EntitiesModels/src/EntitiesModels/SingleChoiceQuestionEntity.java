/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Klasa reprezentująca pytanie zamknięte jednokrotnego wyboru.
 *
 * @author Krzysztof
 */
public class SingleChoiceQuestionEntity extends QuestionEntity {

    private final List<String> answers;
    private int correctAnswer;

    /**
     * Bezparametrowy konstuktor.
     */
    public SingleChoiceQuestionEntity() {
        this.answers = new ArrayList<>();
    }

    /**
     * Pobiera listę dostępnych odpowiedzi.
     *
     * @return Niemodyfikowalna lista odpowiedzi.
     */
    public List<String> getAnswers() {
        return Collections.unmodifiableList(this.answers);
    }

    /**
     * Podaje numer poprawnej odpowiedzi.
     *
     * @return Numer poprawnej odpowiedzi na liście dostępnych odpowiedzi
     * uzyskanej za pomocą metody {@link #getAnswers() getAnswers()}
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Usuwa odpowiedź o podanym indeksie.
     *
     * @param index Numer odpowiedzi na liście dostępnych odpowiedzi uzyskanej
     * za pomocą metody {@link  #getAnswers() getAnswers()}
     */
    public void removeAnswer(int index) {
        this.answers.remove(index);
    }

    /**
     * Dodaje odpowiedź do testu.
     *
     * @param answer Treść odpowiedzi.
     */
    public void addAnswer(String answer) {
        this.answers.add(answer);
    }
}
