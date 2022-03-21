package by.epam.dobrohotov.englishWeb.dao.impl;

import by.epam.dobrohotov.englishWeb.bean.Lesson;
import by.epam.dobrohotov.englishWeb.dao.DataSource;
import by.epam.dobrohotov.englishWeb.dao.LessonDAO;

public class StorageLessonDAO implements LessonDAO {
    private final DataSource dataSource = DataSource.getInstance();

    @Override
    public boolean addLesson(Lesson lesson) {
        return dataSource.getLessons().add(lesson);
    }

    @Override
    public boolean deleteLesson(Lesson lesson) {
        return dataSource.getLessons().remove(lesson);
    }
}
