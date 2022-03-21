package by.epam.dobrohotov.englishWeb.presentation.ViewImpl;

import by.epam.dobrohotov.englishWeb.bean.Person;
import by.epam.dobrohotov.englishWeb.presentation.View;

public class LoginationAdminCommandView implements View {
    private Person personResult;
    private boolean isCorrect;

    public boolean isCorrect() {
        return isCorrect;
    }

    public LoginationAdminCommandView(Person person) {
        this.personResult = person;
    }
    @Override
    public void show() {
        String response;
        if(personResult != null){
            response = "welcome back,admin"+ " " + personResult.getName();
            isCorrect = true;
        }else{
            response = "error";
            isCorrect = false;
        }
        System.out.println(response);
    }
//    public static String registrationAnswer(String result){
//        String response;
//        if (Objects.equals(result, "Exception")){
//            response = "0 error";
//        }else{
//            response = "1 Hello,new person!";
//        }
//        return response;
//    }

}
