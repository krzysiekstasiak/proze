/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerAccess;

import EntitiesModels.GroupEntity;
import EntitiesModels.UserEntity;
import javax.ejb.Remote;

/**
 *
 * @author Krzysztof
 */
@Remote
public interface ServerAccessBeanRemote {

    Boolean Login(String login, String password) throws IllegalStateException;

    void Logout() throws IllegalStateException;

    UserEntity getUserEntity(String login) throws IllegalAccessException;

    void updateUserEntity(UserEntity userEntity) throws IllegalAccessException;

    Boolean registerUser(String login, String password, String firstName, String secondName, String eMail) throws IllegalStateException;

    GroupEntity getGroupEntity(String name) throws IllegalAccessException;

    void updateGroupEntity(GroupEntity groupEntity) throws IllegalAccessException;

    Boolean createGroup(String name, String description) throws IllegalAccessException;

    void addUserToGroup(String groupName, String userLogin) throws IllegalAccessException;

    Boolean removeUserFromGroup(String groupName, String userLogin) throws IllegalAccessException;

}
