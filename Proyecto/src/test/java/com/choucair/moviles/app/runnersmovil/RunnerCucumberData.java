/**
 * @since 27/11/2017
 */
package com.choucair.moviles.app.runnersmovil;

import java.io.IOException;
import org.junit.runner.RunWith;
import com.choucair.moviles.app.utils.BeforeSuite;
import com.choucair.moviles.app.utils.DataToFeature;
import  org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@CucumberOptions(
features = "src/test/resources/features"
,tags = {"@MortgageRequest"}
,snippets = SnippetType.CAMELCASE
,glue = "com.choucair.moviles.app")

@RunWith(RunnerPersonalizado.class)
public class RunnerCucumberData {
	
	private RunnerCucumberData() 
	{
		//constructor
	}
	
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}