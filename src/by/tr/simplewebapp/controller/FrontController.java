package by.tr.simplewebapp.controller;

import by.tr.simplewebapp.controller.command.CommandDispatcher;
import by.tr.simplewebapp.controller.command.CommandDirector;
import by.tr.simplewebapp.controller.exception.ControllerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static by.tr.simplewebapp.controller.command.constant.AttributeName.*;
import static by.tr.simplewebapp.controller.command.constant.CommandType.SEND_ERROR;
import static by.tr.simplewebapp.controller.command.constant.JspPath.*;


public class FrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = request.getParameter(COMMAND);
        CommandDirector dispatcherDirector = new CommandDirector();
        CommandDispatcher commandDispatcher = dispatcherDirector.getCommandDispatcher(command);

        try {
            commandDispatcher.execute(request, response);
        } catch (ControllerException ex) {
            String exceptionMessage = ex.getMessage();
            // пользователю никогда не должны уходить внутренние сообщения системы
            response.sendRedirect(FRONT_CONTROLLER_PATH +SIGN_BEFORE_ATTRIBUTES +COMMAND + PARAMETER_VALUE_DIVIDER + SEND_ERROR + ATTRIBUTES_DIVIDER + MESSAGE + PARAMETER_VALUE_DIVIDER + exceptionMessage);
        }

    }
}
