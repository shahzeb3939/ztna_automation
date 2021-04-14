package java.com.ztna.steps.Login;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.ui.com.ztna.login.models.LoginParameters;

import static main.java.indexed.pojo.model.IndexedPojoDeserializer.deserializeJsonTo;

public class Login_Steps {
    LoginParameters loginParameters;

    @Given("user is on login page")
    public void userIsOnLoginPage() {

    }

    @When("user tries to login using {jsonTestData}")
    public void whenStep(JsonObject parameter) {
        loginParameters = deserializeJsonTo(parameter, LoginParameters.class);
        System.out.println("aaa"+loginParameters.email);
        System.out.println("bbb"+loginParameters.password);
    }

    @Then("he should be logged in")
    public void thenStep() {

    }
}
