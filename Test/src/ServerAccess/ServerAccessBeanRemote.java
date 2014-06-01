/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerAccess;

import EntitiesModels.Comment;
import EntitiesModels.GroupEntity;
import EntitiesModels.TestDescription;
import EntitiesModels.TestEntity;
import EntitiesModels.UserEntity;
import java.util.Date;
import java.util.List;
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

    List<UserEntity> getUsersFromGroup(String groupName) throws IllegalAccessException;

    List<TestDescription> getTestsFromGroup(String groupName) throws IllegalAccessException;

    TestEntity createTest(String name, String groupName, String category) throws IllegalAccessException;

    void updateTestEntity(TestEntity testEntity) throws IllegalAccessException;

    Boolean removeTest(long testID) throws IllegalAccessException;

    TestEntity getTestEntity(long testID) throws IllegalAccessException;

    int getTestRating(long testID) throws IllegalAccessException;

    Date getTestModificationDate(long testID) throws IllegalAccessException;

    List<Comment> getTestComments(long testID) throws IllegalAccessException;

    Comment addComment(long testID, String content, int rating) throws IllegalAccessException;

}
