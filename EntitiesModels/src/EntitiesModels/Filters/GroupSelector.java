/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesModels.Filters;

import EntitiesModels.GroupEntity;
import java.io.Serializable;

/**
 * Interfejs obiektu wybierającego grupy podczas wyszukiwania.
 *
 * @author Krzysztof
 */
public interface GroupSelector extends Serializable {

    /**
     * Metoda decydująca, czy grupa spełnia zadane warunki.
     *
     * @param group Obiekt encji grupy.
     * @return Decyzja, czy zaakceptować obiekt.
     */
    public boolean checkGroup(GroupEntity group);
}
