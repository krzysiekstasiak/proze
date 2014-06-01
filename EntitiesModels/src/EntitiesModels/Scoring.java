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
public class Scoring {

    private int pointsForCorrectAnswer;
    private int pointsForNoAnswer;
    private int pointsForWrongAnswer;
    private double timeForAnswer;

    /**
     * Zwraca ilość punktów za poprawną odpowiedź.
     *
     * @return Ilość punktów.
     */
    public int getPointsForCorrectAnswer() {
        return pointsForCorrectAnswer;
    }

    /**
     * Modyfikuje ilość punktów za poprawną odpowiedź.
     *
     * @param pointsForCorrectAnswer Nowa ilość punktów za poprawną odpowiedź.
     */
    public void setPointsForCorrectAnswer(int pointsForCorrectAnswer) {
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
    }

    /**
     * Zwraca ilość punktów za brak odpowiedzi.
     *
     * @return Ilość punktów.
     */
    public int getPointsForNoAnswer() {
        return pointsForNoAnswer;
    }

    /**
     * Ustawia ilość punktów za brak odpowiedzi.
     *
     * @param pointsForNoAnswer Nowa ilość punktów za brak odpowiedzi.
     */
    public void setPointsForNoAnswer(int pointsForNoAnswer) {
        this.pointsForNoAnswer = pointsForNoAnswer;
    }

    /**
     * Zwraca ilość punktów za złą odpowiedź.
     *
     * @return Ilość punktów. Liczba ujemna oznacza punkty ujemne.
     */
    public int getPointsForWrongAnswer() {
        return pointsForWrongAnswer;
    }

    /**
     * Modyfikuje ilość punktów za złą odpowiedź.
     *
     * @param pointsForWrongAnswer Nowa ilośc punktów. Liczba ujemna oznacza
     * punkty ujemne.
     */
    public void setPointsForWrongAnswer(int pointsForWrongAnswer) {
        this.pointsForWrongAnswer = pointsForWrongAnswer;
    }

    /**
     * Zwraca czas na udzielenie odpowiedzi.
     *
     * @return Czas na udzielenie odpowiedzi.
     */
    public double getTimeForAnswer() {
        return timeForAnswer;
    }

    /**
     * Modyfikuje czas na udzielenie odpowiedzi.
     *
     * @exception IllegalArgumentException W przypadku podania ujemnej liczby.
     * @param timeForAnswer Nowy czas na udzielenie odpowiedzi. Wartość musi być
     * dodatnia.
     */
    public void setTimeForAnswer(double timeForAnswer) {
        if (timeForAnswer > 0) {
            this.timeForAnswer = timeForAnswer;
        } else {
            throw new IllegalArgumentException("Time for answer must be a positive number");
        }
    }

}
