package by.epam.dobrohotov.englishWeb.dao;

import by.epam.dobrohotov.englishWeb.bean.Lesson;

public interface LessonDAO {
    boolean addLesson(Lesson lesson);
    boolean deleteLesson(Lesson lesson);
}
