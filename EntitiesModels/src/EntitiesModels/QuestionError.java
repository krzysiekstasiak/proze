/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;

/**
 * Klasa reprezentująca zauważony błąd w pytaniu.
 *
 * @author Krzysztof
 */
public class QuestionError implements Serializable {

    private final long testID;
    private final int questionIndex;
    private final String problemDescription;
    private final String possibleSolution;

    /**
     * Konstruktor klasy.
     *
     * @param testID ID testu, w którym znajduje się pytanie z błędem.
     * @param questionIndex Numer pytania w teście.
     * @param problemDescription Opis problemu.
     * @param possibleSolution Proponowane rozwiązanie.
     */
    public QuestionError(long testID, int questionIndex, String problemDescription, String possibleSolution) {
        this.testID = testID;
        this.questionIndex = questionIndex;
        this.problemDescription = problemDescription;
        this.possibleSolution = possibleSolution;
    }

    /**
     * Zwraca ID testu, w którym znajduje się pytanie z błędem.
     *
     * @return ID testu.
     */
    public long getTestID() {
        return testID;
    }

    /**
     * Zwraca numer pytania w teście.
     *
     * @return Numer pytania w teście.
     */
    public int getQuestionIndex() {
        return questionIndex;
    }

    /**
     * Zwraca opis problemu.
     *
     * @return Opis problemu.
     */
    public String getProblemDescription() {
        return problemDescription;
    }

    /**
     * Zwraca propozycję rozwiązania problemu.
     *
     * @return Propozycja rozwiązania problemu.
     */
    public String getPossibleSolution() {
        return possibleSolution;
    }

}
