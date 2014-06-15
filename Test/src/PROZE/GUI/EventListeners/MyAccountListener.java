/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.GUI.EventListeners;

import EntitiesModels.UserEntity;

/**
 *
 * @author Krzysztof
 */
public interface MyAccountListener {

    /**
     * Uaktualnia konto użytkowniak
     * 
     * @param userEntity użytkownik którego konto jest uaktualniane
     */
    public void accountUpdated(UserEntity userEntity);
}
