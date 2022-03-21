package by.epam.dobrohotov.englishWeb.dao;

import by.epam.dobrohotov.englishWeb.dao.impl.StorageAdminDAO;
import by.epam.dobrohotov.englishWeb.dao.impl.StorageLessonDAO;
import by.epam.dobrohotov.englishWeb.dao.impl.StorageUserDAO;

public final class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();
    private UserDAO userDAO = new StorageUserDAO();
    private AdminDAO adminDAO = new StorageAdminDAO();
    private LessonDAO lessonDAO = new StorageLessonDAO();
    private DAOProvider(){}
    public static DAOProvider getInstance(){
        return instance;
    }
    public UserDAO getUserDAO(){
        return userDAO;
    }
    public AdminDAO getAdminDAO(){
        return adminDAO;
    }
    public LessonDAO getLessonDAO(){
        return lessonDAO;
    }
}
