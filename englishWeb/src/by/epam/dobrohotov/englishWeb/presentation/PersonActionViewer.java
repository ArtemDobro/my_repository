package by.epam.dobrohotov.englishWeb.presentation;

import by.epam.dobrohotov.englishWeb.bean.Person;

import java.util.Objects;

public class PersonActionViewer {
    public static String loginationAnswer(Person personResult){
        String response;
        if(personResult != null){
            response = "1 Hello," + personResult.getName();
        }else{
            response = "0 error";
        }
        return response;
    }
    public static String registrationAnswer(String result){
        String response;
        if (Objects.equals(result, "Exception")){
            response = "0 error";
        }else{
            response = "1 Hello,new person!";
        }
        return response;
    }
}
