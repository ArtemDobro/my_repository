package by.epam.dobrohotov.englishWeb.presentation.ViewImpl;

import by.epam.dobrohotov.englishWeb.presentation.View;

import java.util.Objects;

public class RegistrationAdminCommandView implements View {
    String result;
    private boolean isCorrect;

    public boolean isCorrect() {
        return isCorrect;
    }

    public RegistrationAdminCommandView(String request) {
        this.result = request;
    }

    @Override
    public void show() {
        String response;
        if (Objects.equals(result, "Exception")){
            response = "error";
            isCorrect = false;
        }else{
            response = "Hello,new admin!";
            isCorrect = true;
        }
        System.out.println(response);
    }
}
