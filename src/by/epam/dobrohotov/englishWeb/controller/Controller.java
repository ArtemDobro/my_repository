package by.epam.dobrohotov.englishWeb.controller;

import by.epam.dobrohotov.englishWeb.presentation.View;

import java.io.IOException;
import java.util.List;

public interface Controller {
    View doAction(List<String> request) throws IOException;
}
