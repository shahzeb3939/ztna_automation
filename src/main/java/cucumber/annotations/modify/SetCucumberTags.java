package cucumber.annotations.modify;

import annotations.utils.ModifyAnnotationValue;
import io.cucumber.junit.CucumberOptions;

public class SetCucumberTags {

    String tags;

    public SetCucumberTags(String tags) {
        this.tags = tags;
    }

    public static SetCucumberTags to(String tags) {
        return new SetCucumberTags(tags);
    }
    public Class[] forRunnerClasses(Class... classes) {
        ModifyAnnotationValue.forField("tags").toValue(tags).inAnnotation(CucumberOptions.class).belongingToClasses(classes).alterValue();
        return classes;
    }
}
