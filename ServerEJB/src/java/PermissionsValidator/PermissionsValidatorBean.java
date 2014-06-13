/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PermissionsValidator;

import Auxiliary.Hash;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Krzysztof
 */
@Stateless
public class PermissionsValidatorBean implements PermissionsValidatorBeanLocal {

    private DataSource database;

    @PostConstruct
    public void getDataSource() {
        try {
            this.database = (DataSource) new InitialContext().lookup("jdbc/DatabaseDataSource");
        } catch (NamingException ex) {
            throw new EJBException(ex);
        }
    }

    @Override
    public boolean authenticateUser(String login, String password) {
        String passwordHash = Hash.generateHash(password);//Tymczasowo
        try {
            Connection connection = this.database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT COUNT(*) FROM USERS WHERE login = \'" + login + "\' AND passwordhash = \'" + passwordHash + "\'");
            results.next();
            return results.getInt(1) == 1;
        } catch (SQLException ex) {
            throw new EJBException(ex);
        }
    }

}
