package by.epam.dobrohotov.englishWeb.view.menu;

import by.epam.dobrohotov.englishWeb.controller.Controller;
import by.epam.dobrohotov.englishWeb.controller.controllerImpl.ControllerImpl;
import by.epam.dobrohotov.englishWeb.presentation.View;

import java.io.IOException;
import java.util.Scanner;

public class AuthorizationAdminMenu {
    private boolean isCorrect;

    public boolean isCorrect() {
        return isCorrect;
    }

    public AuthorizationAdminMenu() {
    }

    public static void authorizate() throws IOException {
        Controller controller = new ControllerImpl();
        Scanner in = new Scanner(System.in);
        System.out.print("enter the login\n");
        String login = in.nextLine();
        System.out.print("enter the password\n");
        String password = in.nextLine();
        String request = "logination admin " + login + " " + password;

        View view = controller.doAction(request);
        view.show();

        if (view.isCorrect()) {
            System.out.print("choose the number of command\n");
            System.out.print("1.Add lesson\n");
            System.out.print("2.Delete lesson\n");
            int number = Integer.parseInt(in.nextLine());
            if(number == 1){
                Controller lessonController = new LessonController();
                System.out.print("write the path to lesson\n");
                String path = in.nextLine();
                request = "addLesson"+ " " + path;
                view = lessonController.doAction(request);
                view.show();
            }
        }
    }

    //        String result = response.split("\\s+")[0];
//        System.out.println(response.split("\\s+", 2)[1]);
}
