package by.tr.simplewebapp.controller.command.impl;

import by.tr.simplewebapp.controller.command.CommandDispatcher;
import by.tr.simplewebapp.controller.command.constant.AttributeName;
import by.tr.simplewebapp.controller.command.constant.JspPath;
import by.tr.simplewebapp.controller.exception.ControllerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendErrorCommand implements CommandDispatcher {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ControllerException {
        String errorMessage = request.getParameter(AttributeName.MESSAGE);

        request.setAttribute(AttributeName.MESSAGE, errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher(JspPath.ERROR_PAGE);
        dispatcher.forward(request,response);
    }
}
