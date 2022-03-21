package by.epam.dobrohotov.englishWeb.controller.commands;

import by.epam.dobrohotov.englishWeb.presentation.View;

import java.io.IOException;
import java.util.List;

public interface Command {
    View execute(List<String> params) throws IOException;
}
