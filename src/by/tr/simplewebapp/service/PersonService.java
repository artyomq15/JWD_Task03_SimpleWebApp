package by.tr.simplewebapp.service;

import by.tr.simplewebapp.entity.Person;
import by.tr.simplewebapp.service.exception.ServiceException;

public interface PersonService {
    Person findByNameSurname(String name, String surname) throws ServiceException;
}
