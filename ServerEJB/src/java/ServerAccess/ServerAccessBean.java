/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerAccess;

import EntitiesModels.Comment;
import EntitiesModels.Filters.GroupSelector;
import EntitiesModels.Filters.TestSelector;
import EntitiesModels.GroupEntity;
import EntitiesModels.Notifications.Notification;
import EntitiesModels.QuestionEntity;
import EntitiesModels.TestDescription;
import EntitiesModels.TestEntity;
import EntitiesModels.UserEntity;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Krzysztof
 */
@Stateful
public class ServerAccessBean implements ServerAccessBeanRemote {

    @Override
    public Boolean Login(String login, String password) throws IllegalStateException {
        return null;
    }

    @Override
    public void Logout() throws IllegalStateException {
    }

    @Override
    public UserEntity getUserEntity(String login) throws IllegalAccessException {
        return null;
    }

    @Override
    public void updateUserEntity(UserEntity userEntity) throws IllegalAccessException {
    }

    @Override
    public Boolean registerUser(String login, String password, String firstName, String lastName, String eMail) throws IllegalStateException {
        return null;
    }

    @Override
    public GroupEntity getGroupEntity(String name) throws IllegalAccessException {
        return null;
    }

    @Override
    public void updateGroupEntity(GroupEntity groupEntity) throws IllegalAccessException {
    }

    @Override
    public Boolean createGroup(String name, String description) throws IllegalAccessException {
        return null;
    }

    @Override
    public void addUserToGroup(String groupName, String userLogin) throws IllegalAccessException {
    }

    @Override
    public Boolean removeUserFromGroup(String groupName, String userLogin) throws IllegalAccessException {
        return null;
    }

    @Override
    public List<UserEntity> getUsersFromGroup(String groupName) throws IllegalAccessException {
        return null;
    }

    @Override
    public List<TestDescription> getTestsFromGroup(String groupName) throws IllegalAccessException {
        return null;
    }

    @Override
    public TestEntity createTest(String name, String groupName, String category) throws IllegalAccessException {
        return null;
    }

    @Override
    public void updateTestEntity(TestEntity testEntity) throws IllegalAccessException {
    }

    @Override
    public Boolean removeTest(long testID) throws IllegalAccessException {
        return null;
    }

    @Override
    public TestEntity getTestEntity(long testID) throws IllegalAccessException {
        return null;
    }

    @Override
    public int getTestRating(long testID) throws IllegalAccessException {
        return 0;
    }

    @Override
    public Date getTestModificationDate(long testID) throws IllegalAccessException {
        return null;
    }

    @Override
    public List<Comment> getTestComments(long testID) throws IllegalAccessException {
        return null;
    }

    @Override
    public Comment addComment(long testID, String content, int rating) throws IllegalAccessException {
        return null;
    }

    @Override
    public void reportQuestionError(long testID, int indexInTest, String problemDesciption, String proposedSolution) throws IllegalAccessException {
    }

    @Override
    public void addProposedQuestion(long testID, QuestionEntity question) throws IllegalAccessException {
    }

    @Override
    public Boolean requestJoiningGroup(String userLogin, String groupName) throws IllegalAccessException {
        return null;
    }

    @Override
    public Comment getComment(long commentID) throws IllegalAccessException {
        return null;
    }

    @Override
    public List<Notification> getNotifications() throws IllegalAccessException {
        return null;
    }

    @Override
    public List<GroupEntity> findGroups(GroupSelector groupSelector) throws IllegalAccessException {
        return null;
    }

    @Override
    public List<TestDescription> findTests(TestSelector testSelector) throws IllegalAccessException {
        return null;
    }

}
