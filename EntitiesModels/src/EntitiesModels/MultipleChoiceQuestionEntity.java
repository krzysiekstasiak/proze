/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Klasa reprezentująca pytanie wielokrotnego wyboru.
 *
 * @author Krzysztof
 */
public class MultipleChoiceQuestionEntity {

    private final Map<String, Boolean> answers;

    /**
     * Bezparametrowy konstruktor.
     */
    public MultipleChoiceQuestionEntity() {
        this.answers = new HashMap<>();
    }

    /**
     * Pobiera dostępne odpowiedzi w formie listy.
     *
     * @return Niemodyfikowalna lista odpowiedzi.
     */
    public List<String> getAnswers() {
        return Collections.unmodifiableList(new ArrayList<String>(this.answers.keySet()));
    }

    /**
     * Dodaje odpowiedź do testu i oznacza ją jako błędną. Aby to zmienić należy
     * użyć metody
     * {@link #setAnswerCorrect(java.lang.String, boolean) setAnswerCorrect}
     *
     * @param answer Treść odpowiedzi.
     */
    public void addAnswer(String answer) {
        this.answers.put(answer, false);
    }

    /**
     * Usuwa podaną odpowiedź z pytania.
     *
     * @exception NoSuchElementException W przypadku niewystępowania podanej
     * odpowiedzi w pytaniu.
     * @param answer Treść odpowiedzi.
     */
    public void removeAnswer(String answer) {
        if (this.answers.containsKey(answer)) {
            this.answers.remove(answer);
        } else {
            throw new NoSuchElementException("No such answer.");
        }
    }

    /**
     * Sprawdza, czy odpowiedź jest poprawna.
     *
     * @exception NoSuchElementException W przypadku braku podanej odpowiedzi w
     * pytaniu.
     * @param answer Treść odpowiedzi.
     * @return True, jeśli odpowiedź jest prawdziwa.
     */
    public boolean isAnswerCorrect(String answer) {
        if (this.answers.containsKey(answer)) {
            return this.answers.get(answer);
        } else {
            throw new NoSuchElementException("No such answer.");
        }
    }

    /**
     * Oznacza odpowiedź jako poprawną lub błędną.
     *
     * @exception NoSuchElementException W przypadku braku podanej odpowiedzi w
     * pytaniu.
     * @param answer Odpowiedź.
     * @param correct Poprawność odpowiedzi.
     */
    public void setAnswerCorrect(String answer, boolean correct) {
        if (this.answers.containsKey(answer)) {
            this.answers.put(answer, correct);
        } else {
            throw new NoSuchElementException("No such answer.");
        }
    }
}
