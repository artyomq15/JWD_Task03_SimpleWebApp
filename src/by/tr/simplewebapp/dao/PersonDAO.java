package by.tr.simplewebapp.dao;

import by.tr.simplewebapp.dao.exception.DAOException;
import by.tr.simplewebapp.entity.Person;

public interface PersonDAO {
    Person findByNameSurname(String name, String surname) throws DAOException;
}
