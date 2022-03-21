package com.company;

import by.epam.dobrohotov.englishWeb.presentation.View;
import by.epam.dobrohotov.englishWeb.presentation.ViewImpl.RegistrationAdminCommandView;
import by.epam.dobrohotov.englishWeb.view.menu.AuthorizationAdminMenu;
import by.epam.dobrohotov.englishWeb.view.menu.AuthorizationUserMenu;
import by.epam.dobrohotov.englishWeb.view.menu.RegistrationAdminMenu;
import by.epam.dobrohotov.englishWeb.view.menu.RegistrationUserMenu;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.print("enter the number\n");
    System.out.print("1.sign in\n");
    System.out.print("2.registration\n");
    Scanner in = new Scanner(System.in);
    String number = in.nextLine();
    View view;
    if (Objects.equals(number, "1")) {
      view = new LoginView();
    } else {
      view = new RegistrationAdminCommandView();
    }
    View currentUserView = view.show();
    while (true){
      view = currentUserView.show();
      view.show();
    }
  }
}
//  for (int i = 0; i < 4; ++i) {
//            System.out.print("enter the number\n");
//            System.out.print("1.You are user\n");
//            System.out.print("2.You are admin\n");
//            Scanner in = new Scanner(System.in);
//            String number = in.nextLine();
//            if (Objects.equals(number, "1")) {
//                System.out.print("enter the number\n");
//                System.out.print("1.sign in\n");
//                System.out.print("2.registration\n");
//                number = in.nextLine();
//                if (Objects.equals(number, "1")){
//                    AuthorizationUserMenu.authorizate();
//                }else{
//                    RegistrationUserMenu.registrate();
//                }
//            } else if (Objects.equals(number, "2")) {
//                System.out.print("enter the number\n");
//                System.out.print("1.sign in\n");
//                System.out.print("2.registration\n");
//                number = in.nextLine();
//                if (Objects.equals(number, "1")){
//                    AuthorizationAdminMenu.authorizate();
//                }else{
//                    RegistrationAdminMenu.registrate();
//                }
//            }
//        }