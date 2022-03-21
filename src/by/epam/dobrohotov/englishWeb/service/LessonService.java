package by.epam.dobrohotov.englishWeb.service;

import by.epam.dobrohotov.englishWeb.bean.Lesson;

public interface LessonService {
    boolean addLesson(Lesson lesson);
    boolean deleteLesson(Lesson lesson);
}
