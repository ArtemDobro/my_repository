package by.epam.dobrohotov.englishWeb.service.impl;

import by.epam.dobrohotov.englishWeb.bean.Lesson;
import by.epam.dobrohotov.englishWeb.service.LessonService;
import by.epam.dobrohotov.englishWeb.dao.DAOProvider;

public class LessonServiceImpl implements LessonService {
    private final DAOProvider daoProvider = DAOProvider.getInstance();

    @Override
    public boolean addLesson(Lesson lesson) {
        return daoProvider.getLessonDAO().addLesson(lesson);
    }

    @Override
    public boolean deleteLesson(Lesson lesson) {
        return daoProvider.getLessonDAO().deleteLesson(lesson);
    }
}
