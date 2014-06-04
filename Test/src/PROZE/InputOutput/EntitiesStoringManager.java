/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROZE.InputOutput;

/**
 *
 * @author Krzysztof
 */
class EntitiesStoringManager {

    private EntitiesStoringManager() {
    }

    public static EntitiesStoringManager getInstance() {
        return EntitiesStoringManagerHolder.INSTANCE;
    }

    private static class EntitiesStoringManagerHolder {

        private static final EntitiesStoringManager INSTANCE = new EntitiesStoringManager();
    }
}
