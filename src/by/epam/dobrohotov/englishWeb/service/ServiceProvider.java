package by.epam.dobrohotov.englishWeb.service;

import by.epam.dobrohotov.englishWeb.service.impl.LessonServiceImpl;
import by.epam.dobrohotov.englishWeb.service.impl.UserServiceImpl;
import by.epam.dobrohotov.englishWeb.service.impl.AdminServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();
    private UserService userService = new UserServiceImpl();
    private AdminService adminService = new AdminServiceImpl();
    private LessonService lessonService = new LessonServiceImpl();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public LessonService getLessonService() {
        return lessonService;
    }
}
