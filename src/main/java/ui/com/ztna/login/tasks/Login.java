package ui.com.ztna.login.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.com.ztna.login.models.LoginParameters;

import static ui.com.ztna.login.user_interface.SignInFormUI.*;

public class Login {

    public static Task usingCredentials(LoginParameters parameters) {
        return Task.where("{0} logins using credentials",
                Enter.theValue(parameters.email).into(EMAIL_FIELD),
                Enter.theValue(parameters.password).into(PASSWORD_FIELD),
                Click.on(SIGN_IN_BUTTON)
        );
    }
}
