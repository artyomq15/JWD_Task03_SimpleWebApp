package by.tr.simplewebapp.dao;


import by.tr.simplewebapp.dao.impl.PersonDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final PersonDAO personDAO = new PersonDAOImpl();

    private DAOFactory() {}

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
