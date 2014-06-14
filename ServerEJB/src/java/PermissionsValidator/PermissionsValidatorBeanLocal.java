/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PermissionsValidator;

import javax.ejb.Local;

/**
 *
 * @author Krzysztof
 */
@Local
public interface PermissionsValidatorBeanLocal {

    boolean authenticateUser(String login, String password);

}
