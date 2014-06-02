/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels.Filters;

import EntitiesModels.TestEntity;
import java.io.Serializable;

/**
 * Interfejs obiektu wybierającego test podczas wyszukiwania.
 *
 * @author Krzysztof
 */
public interface TestSelector extends Serializable {

    /**
     * Metoda decydująca, czy test spełnia zadane warunki.
     *
     * @param test Obiekt encji testu.
     * @return True, jeśli obiekt spełnia zadane warunki.
     */
    public boolean checkTest(TestEntity test);
}
