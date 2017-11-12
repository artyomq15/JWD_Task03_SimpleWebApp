package by.tr.simplewebapp.controller.command;


import by.tr.simplewebapp.controller.exception.ControllerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CommandDispatcher {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ControllerException;
}
