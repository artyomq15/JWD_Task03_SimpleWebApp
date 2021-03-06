package by.tr.simplewebapp.controller.command.impl;

import by.tr.simplewebapp.controller.command.CommandDispatcher;
import by.tr.simplewebapp.controller.command.constant.JspPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GoToMainPageCommand implements CommandDispatcher {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(JspPath.INDEX_PAGE);
    }
}
