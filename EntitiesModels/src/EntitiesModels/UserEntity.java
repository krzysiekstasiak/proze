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
public class UserEntity {

    private final String login;
    private String firstName;
    private String secondName;
    private String mailAddress;
    private final boolean editPermissions;

    public UserEntity(String login, boolean editPermissions) {
        this.login = login;
        this.editPermissions = editPermissions;
    }

    public boolean editPermitted() {
        return this.editPermissions;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

}
