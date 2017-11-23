package by.tr.simplewebapp.service.impl;

import by.tr.simplewebapp.dao.DAOFactory;
import by.tr.simplewebapp.dao.PersonDAO;
import by.tr.simplewebapp.dao.exception.DAOException;
import by.tr.simplewebapp.entity.Person;
import by.tr.simplewebapp.service.PersonService;
import by.tr.simplewebapp.service.exception.ServiceException;

public class PersonServiceImpl implements PersonService {
    @Override
    public Person findByNameSurname(String name, String surname) throws ServiceException{
        // куда делась валидация данных в сервисе?
        Person person;

        DAOFactory daoFactory = DAOFactory.getInstance();
        PersonDAO personDAO = daoFactory.getPersonDAO();

        try{
            person = personDAO.findByNameSurname(name, surname);
        } catch (DAOException ex){
            throw new ServiceException(ex);
        }
        return person;
    }
}
