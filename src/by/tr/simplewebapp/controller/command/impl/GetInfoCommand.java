package by.tr.simplewebapp.controller.command.impl;

import by.tr.simplewebapp.controller.command.CommandDispatcher;
import by.tr.simplewebapp.controller.exception.ControllerException;
import by.tr.simplewebapp.entity.Person;
import by.tr.simplewebapp.service.PersonService;
import by.tr.simplewebapp.service.ServiceFactory;
import by.tr.simplewebapp.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GetInfoCommand implements CommandDispatcher {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ControllerException {
        String name =  request.getParameter("name");
        String surname = request.getParameter("surname");

        Person person;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        PersonService personService = serviceFactory.getPersonService();
        try{
            person = personService.findByNameSurname(name,surname);
        } catch (ServiceException ex){
            throw new ControllerException(ex);
        }

        request.setAttribute("person", person);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/infopage.jsp");
        dispatcher.forward(request,response);
    }
}
