package by.epam.dobrohotov.englishWeb.presentation.ViewImpl;

import by.epam.dobrohotov.englishWeb.presentation.View;
import java.util.Scanner;

public class LoginView implements View {

  @Override
  public View show() {
    while(true) {
      System.out.println("Введите логин: ");
      Scanner scan = new Scanner(System.in);
      String login = scan.nextLine();
      System.out.println("Введите пароль: ");
      //Scanner scan = new Scanner(System.in);
      String pass = scan.nextLine();
      //TODO if login success then go forward else try login again
      if (!(login.equals("user") &&pass.equals("user"))){
        System.out.println("login fail");
        continue;
      } else if (!(login.equals("user") &&pass.equals("user"))){
        System.out.println("login fail");
        continue;
      } else {
        System.out.println("login success");
        if (login.equals("user")) return new UserView();
        if (login.equals("admin")) return new AdminView();
        //TODO support any user
        break;
      }

    }
    return null;
  }

  @Override
  public boolean isCorrect() {
    return false;
  }
}
