package java.com.ztna.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;

import static java.com.ztna.parameters.Parameters.actor;

public class NavigationHooks {
    public final static int ORDER = 3;
    static Actor actor = actor("user");


    @Before(value = "@somePlace", order = ORDER)
    public void load_column_dictionary() {
        actor.attemptsTo();
    }
}
