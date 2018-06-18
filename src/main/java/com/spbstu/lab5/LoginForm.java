package com.spbstu.lab5;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.spbstu.lab5.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(css = "#Login")
    public TextField name;

    @FindBy(css = "#Password")
    public TextField password;

    @FindBy(css = "form .btn-login")
    public Button submit;
}