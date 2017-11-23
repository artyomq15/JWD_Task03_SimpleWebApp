package by.tr.simplewebapp.controller.command.impl;

import by.tr.simplewebapp.controller.command.CommandDispatcher;
import by.tr.simplewebapp.controller.command.constant.AttributeName;
import by.tr.simplewebapp.controller.command.constant.JspPath;
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
        String name =  request.getParameter(AttributeName.NAME);
        String surname = request.getParameter(AttributeName.SURNAME);

        Person person;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        PersonService personService = serviceFactory.getPersonService();
        try{
            person = personService.findByNameSurname(name,surname);
        } catch (ServiceException ex){
            throw new ControllerException(ex);// ну и зачем сервлету это твое исключение
            // ты уже тут на слое контроля, вон, внизу форвард используешь
            // пользователя на страницу ошибок переправить не можешь? или просто - ну хай буде и тут исключение?
        }

        request.setAttribute(AttributeName.PERSON, person);

        RequestDispatcher dispatcher = request.getRequestDispatcher(JspPath.INFO_PAGE);
        dispatcher.forward(request,response);
    }
}
