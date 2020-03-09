/**
 * @since 27/11/2017
 */
package com.choucair.moviles.app.runnersmovil;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import com.choucair.moviles.app.utils.BeforeSuite;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * Personalización del Runner con el cual se puede determinar que busque y modifique los .feature antes de ser ejecutados
 * @since 27/11/2017
 * @author bgaona
 *
 */
public class RunnerPersonalizado extends Runner {
	 
	 private Class<CucumberWithSerenity> classValue;
	 private CucumberWithSerenity cucumberWithSerenity;
	 private static final Logger LOGGER = Logger.getLogger(RunnerPersonalizado.class.getName());
	 
	 
	 public RunnerPersonalizado(Class<CucumberWithSerenity> classValue) throws InitializationError, IOException {
	        this.classValue = classValue;
	        cucumberWithSerenity = new CucumberWithSerenity(classValue);
	    }
	 
	  @Override
	    public Description getDescription() {
	        return cucumberWithSerenity.getDescription();
	    }
	  
	  private void runAnnotatedMethods(Class<?> annotation) throws IllegalAccessException, InvocationTargetException {
	        if (!annotation.isAnnotation()) {
	            return;
	        }
	        Method[] methods = this.classValue.getMethods();
	        for (Method method : methods) {
	            Annotation[] annotations = method.getAnnotations();
	            for (Annotation item : annotations) {
	                if (item.annotationType().equals(annotation)) {
	                    method.invoke(null);
	                    break;
	                }
	            }
	        }
	  }
	  
	  @Override
	    public void run(RunNotifier notifier) {
	        try {
	            runAnnotatedMethods(BeforeSuite.class);
	            cucumberWithSerenity = new CucumberWithSerenity(classValue);
	        } catch (Exception e) {
	        	LOGGER.log(Level.SEVERE, e.getMessage());
	        }
	        cucumberWithSerenity.run(notifier);
	    }
}

