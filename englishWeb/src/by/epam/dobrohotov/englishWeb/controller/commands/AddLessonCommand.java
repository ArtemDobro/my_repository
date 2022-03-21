package by.epam.dobrohotov.englishWeb.controller.commands;

import by.epam.dobrohotov.englishWeb.bean.Lesson;
import by.epam.dobrohotov.englishWeb.presentation.View;
import by.epam.dobrohotov.englishWeb.presentation.ViewImpl.AddLessonCommandView;
import by.epam.dobrohotov.englishWeb.service.LessonService;
import by.epam.dobrohotov.englishWeb.service.ServiceProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddLessonCommand implements Command{
    @Override
    public View execute(List<String> params) throws IOException {
        ServiceProvider provider = ServiceProvider.getInstance();
        LessonService lessonService = provider.getLessonService();

        String path = params.get(1);
        String strLesson = readUsingFiles(path);
        Lesson lesson = new Lesson(strLesson);
        boolean result = lessonService.addLesson(lesson);
        return new AddLessonCommandView(result);
    }
    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
