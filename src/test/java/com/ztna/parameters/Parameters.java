package com.ztna.parameters;

import com.google.gson.JsonObject;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matcher;

import java.io.File;
import java.util.List;

import static com.ztna.hooks.RemembranceHooks.SCENARIO_MEMORY_KEY;
import static cucumber.scenarios.example.reader.json.TestData.getExamplesForScenario;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;
import static string.utils.StringUtils.toList;

public class Parameters {
    @ParameterType(".*")
    public static Actor actor(String actor) {
        return OnStage.theActorCalled(actor);
    }

    @ParameterType(".*")
    public static List<String> list(String stringifiedList) {

        return toList(stringifiedList);
    }

    @ParameterType(".*")
    public static Matcher isEmpty(String expectedValue) {
        if (expectedValue.equals("not empty")) {
            return hasItem(not(isEmptyString()));
        } else {
            return everyItem(isEmptyString());
        }
    }

    @ParameterType(".*")
    public static JsonObject jsonTestData(String exampleReference) {
        Scenario scenario = theActorInTheSpotlight().recall(SCENARIO_MEMORY_KEY);
        JsonObject currentExample = new JsonObject();

        try {
            currentExample = getExamplesForScenario(scenario).get(exampleReference).getAsJsonObject();
        } catch (NullPointerException exception) {
            throw new RuntimeException("Unable to find Example reference \""+exampleReference+"\" in Json data file");
        }
        return currentExample;
    }

    @ParameterType(".*")
    public static File file(String filePath) {
        return new File(filePath);
    }
}
