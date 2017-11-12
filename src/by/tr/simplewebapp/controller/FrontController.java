package by.tr.simplewebapp.controller;

import by.tr.simplewebapp.controller.command.CommandDispatcher;
import by.tr.simplewebapp.controller.command.CommandDirector;
import by.tr.simplewebapp.controller.exception.ControllerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String command = request.getParameter("command");
        CommandDirector dispatcherDirector = new CommandDirector();
        CommandDispatcher commandDispatcher = dispatcherDirector.getCommandDispatcher(command);

        try {
            commandDispatcher.execute(request, response);
        } catch (ControllerException ex){
            System.out.println("Executing command exception");
            ex.printStackTrace();
        }

    }
}
