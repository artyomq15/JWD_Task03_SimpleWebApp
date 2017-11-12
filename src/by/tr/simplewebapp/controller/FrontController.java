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
            response.sendRedirect("FrontController?" +COMMAND + "=" + SEND_ERROR + "&" + MESSAGE + "=" + exceptionMessage);
        }

    }
}
