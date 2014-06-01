/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels;

import java.io.Serializable;

/**
 * Klasa reprezentująca encję pytania.
 *
 * @author Krzysztof
 */
public abstract class QuestionEntity implements Serializable {

    private String content;
    private Scoring scoring;

    /**
     * Zwraca treść pytania.
     *
     * @return Treść pytania.
     */
    public String getContent() {
        return content;
    }

    /**
     * Modyfikuje treść pytania.
     *
     * @param content Nowa treść pytania.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Pobiera punktację pytania.
     *
     * @return Punktacja.
     */
    public Scoring getScoring() {
        return scoring;
    }

    /**
     * Ustawia punktację pytania.
     *
     * @param scoring Nowa punktacja.
     */
    public void setScoring(Scoring scoring) {
        this.scoring = scoring;
    }

}
