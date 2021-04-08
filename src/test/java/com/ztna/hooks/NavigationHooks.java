package com.dvsum.hooks;

import ui.com.dvsum.navigate.tasks.Navigate;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;

import static com.dvsum.parameters.Parameters.actor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class NavigationHooks {
    public final static int ORDER = 3;
    static Actor actor = actor("user");


    @Before(value = "@columnDictionary", order = ORDER)
    public void load_column_dictionary() {
        actor.attemptsTo(Navigate.to("column_dictionary.page"));
    }

    @Before(value = "@manageSources", order = ORDER)
    public void load_manage_sources() {
        actor.attemptsTo(Navigate.to("manage_sources.page"));
    }

    @Before(value = "@profiling", order = ORDER)
    public void load_profiling() {
        actor.attemptsTo(Navigate.to("profiling.page"));
    }

    @Before(value = "@manageRules",order = ORDER)
    public void load_manage_rules() {
        actor.attemptsTo(Navigate.to("manage_rules.page"));
    }

    @Before(value = "@datasetsPage",order = ORDER)
    public void load_datasets_page(){
        theActorInTheSpotlight().attemptsTo(
                Navigate.to("datasets.page")
        );
    }

    @Before(value = "@terms", order = ORDER)
    public void load_terms() {
        actor.attemptsTo(Navigate.to("terms.page"));
    }

    @Before(value = "@fileUpload",order = ORDER)
    public void load_file_upload() {
        actor.attemptsTo(Navigate.to("file_upload.page"));
    }

    @Before(value = "@manageAccount",order = ORDER)
    public void load_manage_account() {
        actor.attemptsTo(Navigate.to("manage_account.page"));
    }

}
