package by.epam.dobrohotov.englishWeb.presentation.ViewImpl;

import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.presentation.View;

public class LoginationUserCommandView implements View {
    private Person personResult;
    private boolean isCorrect;
    public LoginationUserCommandView(Person person) {
        this.personResult = person;
    }

    @Override
    public void show() {
        String response;
        if(personResult != null){
            response = "welcome back,user"+ " " + personResult.getName();
            isCorrect = true;
        }else{
            response = "error";
            isCorrect = false;
        }
        System.out.println(response);

    }

    @Override
    public boolean isCorrect() {
        return isCorrect;
    }
}
