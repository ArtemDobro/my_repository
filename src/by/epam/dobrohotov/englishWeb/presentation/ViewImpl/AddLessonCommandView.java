package by.epam.dobrohotov.englishWeb.presentation.ViewImpl;

import by.epam.dobrohotov.englishWeb.presentation.View;

public class AddLessonCommandView implements View {
    private boolean result;
    private boolean isCorrect;

    public AddLessonCommandView(boolean result) {
        this.result = result;
    }

    @Override
    public void show() {
        String response;
        if (result) {
            response = "New lesson is added";
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
