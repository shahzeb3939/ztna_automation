package ui.com.ztna.login.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class SignInFormUI {

    public static final Target EMAIL_FIELD = Target.the("Email field")
            .locatedBy("//input[@name='email']");

    public static final Target PASSWORD_FIELD = Target.the("Password field")
            .locatedBy("//input[@name='password']");

    public static final Target SIGN_IN_BUTTON = Target.the("Sign in button")
            .locatedBy("//span[.='Sign in']");
}
