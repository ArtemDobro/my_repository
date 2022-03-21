package by.epam.dobrohotov.englishWeb.view.menu;

import by.epam.dobrohotov.englishWeb.controller.Controller;
import by.epam.dobrohotov.englishWeb.presentation.View;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationUserMenu {
    public static void registrate() throws IOException {
        Controller controller = new UserController();
        Scanner in = new Scanner(System.in);
        System.out.print("enter the name\n");
        String name = in.nextLine();
        System.out.print("enter the age\n");
        int age = in.nextInt();
        in.nextLine();
        System.out.print("enter the login\n");
        String login = in.nextLine();
        System.out.print("enter the password\n");
        String password = in.nextLine();
        String request = "registration user " + name + " " + age + " " + login + " " + password;
        View response;
        response = controller.doAction(request);
        response.show();
//        String result = response.split("\\s+")[0];
//        System.out.println(response.split("\\s+", 2)[1]);
    }
}
