package by.epam.dobrohotov.englishWeb.presentation.ViewImpl;

import by.epam.dobrohotov.englishWeb.presentation.View;

import java.util.Objects;

public class RegistrationUserCommandView implements View {
    String result;
    private boolean isCorrect;
    public RegistrationUserCommandView(String result) {
        this.result = result;
    }

    @Override
    public void show() {
        String response;
        if (Objects.equals(result, "Exception")){
            response = "error";
            isCorrect = false;
        }else{
            response = "Hello,new user!";
            isCorrect = true;
        }
        System.out.println(response);
    }

    @Override
    public boolean isCorrect() {
        return isCorrect;
    }
}
