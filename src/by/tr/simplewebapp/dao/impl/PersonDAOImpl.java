package by.tr.simplewebapp.dao.impl;


import by.tr.simplewebapp.dao.PersonDAO;
import by.tr.simplewebapp.dao.datasource.DataSourceFactory;
import by.tr.simplewebapp.dao.exception.DAOException;
import by.tr.simplewebapp.entity.Person;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAOImpl implements PersonDAO{
    private final String FIND_BY_NAME_SURNAME = "SELECT * FROM person WHERE name_person=? AND surname_person=?";

    private final MysqlDataSource dataSource;

    public PersonDAOImpl(){
        DataSourceFactory dataSourceFactory = DataSourceFactory.getInstance();
        dataSource = dataSourceFactory.getDataSource().getMysqlDataSource();
    }

    @Override
    public Person findByNameSurname(String name, String surname) throws DAOException{
        Person person = new Person();
        try(Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME_SURNAME) ){
            statement.setString(1, name);
            statement.setString(2, surname);


            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setSurname(resultSet.getString(3));
                person.setMobilePhoneNumber(resultSet.getString(4));
                person.setEmail(resultSet.getString(5));
            } else {
                return null;
            }

        }catch (SQLException ex) {
            throw new DAOException("Find Person SQL Exception", ex);
        }
        return person;

    }
}
