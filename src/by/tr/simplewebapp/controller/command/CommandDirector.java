package by.tr.simplewebapp.controller.command;

import by.tr.simplewebapp.controller.command.constant.CommandType;
import by.tr.simplewebapp.controller.command.impl.GetInfoCommand;
import by.tr.simplewebapp.controller.command.impl.GoToMainPageCommand;
import by.tr.simplewebapp.controller.command.impl.SendErrorCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandDirector {
    private Map<String, CommandDispatcher> dispatcherMap = new HashMap<>();

    {
        dispatcherMap.put(CommandType.GO_TO_MAIN_PAGE, new GoToMainPageCommand());
        dispatcherMap.put(CommandType.GET_INFO, new GetInfoCommand());
        dispatcherMap.put(CommandType.SEND_ERROR, new SendErrorCommand());
    }

    public CommandDirector(){}

    public CommandDispatcher getCommandDispatcher(String commandType){
        return dispatcherMap.get(commandType);
    }
}
