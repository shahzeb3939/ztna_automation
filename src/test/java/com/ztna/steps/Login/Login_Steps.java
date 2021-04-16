package com.ztna.steps.Login;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import ui.com.ztna.login.models.LoginParameters;
import ui.com.ztna.login.tasks.Login;

import static indexed.pojo.model.IndexedPojoDeserializer.deserializeJsonTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class Login_Steps {
    LoginParameters loginParameters;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        theActorInTheSpotlight().attemptsTo(Open.browserOn().thePageNamed("webdriver.base.url"));
    }

    @When("user tries to login using {jsonTestData}")
    public void whenStep(JsonObject parameter) {
        loginParameters = deserializeJsonTo(parameter, LoginParameters.class);
        theActorInTheSpotlight().attemptsTo(Login.usingCredentials(loginParameters));
    }

    @Then("user should be logged in")
    public void thenStep() {
    }
}
