/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.EntitiesModels;

/**
 *
 * @author Krzysztof
 */
public class Scoring {

    private int pointsForRightAnswer;
    private int pointsForNoAnswer;
    private int pointsForBadAnswer;
    private float timeForAnswer;

    /**
     * Konstruktor klasy.
     * @param pointsForRightAnswer Punkty za poprawną odpowiedź.
     * @param pointsForNoAnswer Punkty za brak odpowiedzi (ujemna wartość oznacza punkty ujemne).
     * @param pointsForBadAnswer Punkty za błędną odpowiedź (ujemna wartość oznacza punkty ujemne).
     * @param timeForAnswer Czas na udzielenie odpowiedzi (musi być dodatnią wartością).
     */
    public Scoring(int pointsForRightAnswer, int pointsForNoAnswer, int pointsForBadAnswer, float timeForAnswer) {
        this.pointsForRightAnswer = pointsForRightAnswer;
        this.pointsForNoAnswer = pointsForNoAnswer;
        this.pointsForBadAnswer = pointsForBadAnswer;
        if (timeForAnswer > 0) {
            this.timeForAnswer = timeForAnswer;
        } else {
            throw new IllegalArgumentException("Time has to be a positive number");
        }
    }

    /**
     * Zwraca punktację za poprawną odpowiedź.
     * @return Ilość punktów za poprawną odpowiedź.
     */
    public int getPointsForRightAnswer() {
        return pointsForRightAnswer;
    }

    /**
     * Ustawia punktację za poprawną odpowiedź.
     * @param pointsForRightAnswer Ilość punktów za poprawną odpowiedź.
     */
    public void setPointsForRightAnswer(int pointsForRightAnswer) {
        this.pointsForRightAnswer = pointsForRightAnswer;
    }

    /**
     * Zwraca punktację za brak odpowiedzi.
     * @return Ilość punktów za brak odpowiedzi.
     */
    public int getPointsForNoAnswer() {
        return pointsForNoAnswer;
    }

    /**
     * Ustawia punktację za brak odpowiedzi.
     * @param pointsForNoAnswer Ilość punktów za brak odpowiedzi.
     */
    public void setPointsForNoAnswer(int pointsForNoAnswer) {
        this.pointsForNoAnswer = pointsForNoAnswer;
    }

    /**
     * Zwraca punktację za błędną odpowiedź.
     * @return Ilośc punktów za błędną odpowiedź.
     */
    public int getPointsForBadAnswer() {
        return pointsForBadAnswer;
    }

    /**
     * Ustawia punktację za błędną odpowiedź.
     * @param pointsForBadAnswer Ilość punktów za błędną odpowiedź.
     */
    public void setPointsForBadAnswer(int pointsForBadAnswer) {
        this.pointsForBadAnswer = pointsForBadAnswer;
    }

    /**
     * Zwraca czas na udzielenie odpowiedzi.
     * @return Czas na udzielenie odpowiedzi.
     */
    public float getTimeForAnswer() {
        return timeForAnswer;
    }

    /**
     * Ustawia czas na udzielenie odpowiedzi.
     * @param timeForAnswer Czas na udzielenie odpowiedzi. Musi być liczbą dodatnią.
     */
    public void setTimeForAnswer(float timeForAnswer) {
        if (timeForAnswer <= 0) {
            throw new IllegalArgumentException("Time has to be positive number");
        }
        this.timeForAnswer = timeForAnswer;
    }
}
