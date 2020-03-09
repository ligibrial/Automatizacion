/**
 * @since 27/11/2017
 */
package com.choucair.moviles.app.runnersmovil;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@CucumberOptions(
features = "src/test/resources/features"
,tags = {"@MakePayment"}
,snippets = SnippetType.CAMELCASE
,glue = "com.choucair.moviles.app.definitions")

@RunWith(CucumberWithSerenity.class)
public class RunnerCucumber {
}