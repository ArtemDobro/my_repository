package by.epam.dobrohotov.englishWeb.view.menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CommandsAdminMenu {
    private static CommandsAdminMenu instance = new CommandsAdminMenu();

    public static CommandsAdminMenu getInstance() {
        return instance;
    }

    private CommandsAdminMenu() {
    }

    public static void addLesson(String path) throws IOException {
       String contents = readUsingFiles(path);
    }
    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
