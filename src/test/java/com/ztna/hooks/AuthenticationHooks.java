package com.dvsum.hooks;

import ui.com.dvsum.login.tasks.API_Login;
import ui.com.dvsum.navigate.tasks.Navigate;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.dvsum.parameters.Parameters.actor;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class AuthenticationHooks {
    public final static int ORDER = 2;
    public static Actor actor;


    @Before(order = 1)
    public void set_the_stage() {
        setTheStage(new OnlineCast());
        actor = actor("user");
    }

    @Before(value = "@loggedIn", order = ORDER)
    public void api_log_in() {
        actor.attemptsTo(Navigate.to("home.page").then(API_Login.toApp()));
    }
}