package com.choucair.moviles.app.utils;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.webdriver.WebDriverFacade;

public class AccionesObjetos extends MobilePageObject
{
	@SuppressWarnings("unchecked")
	AppiumDriver<MobileElement> conexionAppium = ((AppiumDriver<MobileElement>)((WebDriverFacade) getDriver()).getProxiedDriver());
	public AppiumDriver<MobileElement> getConexionAppium(){return this.conexionAppium;}
	private final Logger logger = Logger.getLogger(AccionesObjetos.class.getName());
	
	private int tiempoEspera = 15;
	private static final int TIEMPO_DEFECTO = 15;
	public void setTiempoEspera(int newTime) {this.tiempoEspera = newTime;}
	 
	public AccionesObjetos(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	public void hideKeyboard(){
		try {
			 conexionAppium.hideKeyboard();
		 } catch (Exception e) {
			 logger.info("Error al esconder el teclado");
		 }
	}
	
	public void setInputText(WebElement el, String dato)
	{		
		if(isAndroid()) {
			System.out.println("entrando a android");
			el.clear();
			el.sendKeys(dato);
			hideKeyboard();
			Serenity.takeScreenshot();
			getAndroidDriver().pressKey(new KeyEvent(AndroidKey.CLEAR));
		}else{
			System.out.println("entrando a ios");
			el.clear();
			el.sendKeys(dato);
			//hideKeyboard();
			Serenity.takeScreenshot();
		}
			
	
	}
	
	public void setInputText(String [] elementos, String dato)
	{
		setInputText(esperarObtenerObjetos(elementos), dato);
	}
	
	public void clickObjeto(WebElement el)
	{
		tap(el);
		Serenity.takeScreenshot();
	}
	
	public void clickObjeto(String [] elementos)
	{
		clickObjeto(esperarObtenerObjetos(elementos));
	}
	/***
	 * selecciona valor haciendo scroll Android
	 * @param param valor a buscar
	 */
	public void selecctScroll(String param) {
		 WebElement element1 = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
				 "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+param+"\").instance(0))"));
		 clickObjeto(esperarObtenerObjetos(element1));	
	}
	/***
	 * selecciona valor haciendo scroll IOs
	 * @param param valor a buscar
	 */
	
	
	
	

	
	private void verticalSwipe() {
		// TODO Auto-generated method stub
		
		Dimension dim = (getDriver().manage().window().getSize());
		System.out.println("la dimension es"+dim);
		   int height=dim.getHeight();
		   int width= dim.getWidth();
		   int x = width/2;
		   int starty= (int)(height*0.80);
	       int endy= (int)(height*0.20);
	      
	      swipe(x, starty, x, endy);
       
		
	}

	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado, 30seg
	 * @param pro propiedad por el cual será buscado id, class, xpath
	 * @param prop valor de la propiedad
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement esperarObtenerObjetos(String pro, String prop)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), this.tiempoEspera);
		WebElement element = null;
		switch(pro)
		{
			default:
			case Locators.ID:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop)));
				element = getDriver().findElement(By.id(prop));
			break;
			case Locators.XPATH:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop)));
				element = getDriver().findElement(By.xpath(prop));
			break;
			case Locators.CLASS_NAME:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(prop)));
				element = getDriver().findElement(By.className(prop));
			break;
		}
		setTiempoEspera(TIEMPO_DEFECTO);
		return element;
	}
	
	/***
	* Metodo para encontrar una lista de objetos esperando un tiempo maximo determinado, 30seg
	* @param pro propiedad por el cual será buscado id, class, xpath
	* @param prop valor de la propiedad
	* @return List<WebElement> con los cual interactuar, null sino se encuentra
	*/
	public List<WebElement> esperarObtenerObjetosLista(String pro, String prop)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), this.tiempoEspera);
		List<WebElement> element = null;

		switch(pro)
		{
			default:
			case Locators.ID:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop)));
				element = getDriver().findElements(By.id(prop));
			break;
			case Locators.XPATH:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop)));
				element = getDriver().findElements(By.xpath(prop));
			break;
			case Locators.CLASS_NAME:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(prop)));
				element = getDriver().findElements(By.className(prop));
			break;
		}
		setTiempoEspera(TIEMPO_DEFECTO);
		return element;
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado
	 * @param pro propiedad por el cual será buscado id, class, xpath
	 * @param prop valor de la propiedad
	 * @param tiempoEspera tiempo maximo a esperar en segundos 
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement esperarObtenerObjetos(String pro, String prop,int tiempoEspera)
	{
		setTiempoEspera(tiempoEspera);
		return esperarObtenerObjetos(pro, prop);
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado, 30seg
	 * @param elemento WebElemento que se desea encontrar
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement esperarObtenerObjetos(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(getDriver(), tiempoEspera);
		setTiempoEspera(TIEMPO_DEFECTO);
		return wait.until(ExpectedConditions.visibilityOf(elemento));
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado
	 * @param elemento WebElemento que se desea esperar
	 * @param tiempoEspera tiempo maximo a esperar en segundos 
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement esperarObtenerObjetos(WebElement elemento,int tiempoEspera) {
		setTiempoEspera(tiempoEspera);
		return esperarObtenerObjetos(elemento);
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado, 30seg
	 * @param propiedades array con las propiedades del elemento
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement esperarObtenerObjetos(String[] propiedades) {
		String[] propi=	obtenerPropiedadesAndroidIos(propiedades);
		return esperarObtenerObjetos(propi[0], propi[1]);
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado
	 * @param propiedades array con las propiedades del elemento
	 * @param tiempoEspera tiempo maximo a esperar en segundos 
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement esperarObtenerObjetos(String[] propiedades,int tiempoEspera) {
		setTiempoEspera(tiempoEspera);
		return esperarObtenerObjetos(propiedades);
	}
	
    /***
	 * Metodo para encontrar una lista de objetos esperando un tiempo maximo determinado, 30seg
	 * @param propiedades array con las propiedades del elemento
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public List<WebElement> esperarObtenerObjetosLista(String[] propiedades){
		String[] propi = obtenerPropiedadesAndroidIos(propiedades);
		return esperarObtenerObjetosLista(propi[0], propi[1]);
	}
	
	/***
	 * Metodo para retornar las propidades dependiendo si es iOs o Android
	 * @param propiedades Array de String con 4 elementos, los dos primeros son las propiedades de Android, los 2 ultimos las de iOS 
	 * @return Array de String con las propiedades de Android o iOS
	 */
	private String[] obtenerPropiedadesAndroidIos(String[] propiedades) {
		String[] elemento = new String[2];
		String current = getConexionAppium().getCapabilities().getCapability("platformName").toString().toLowerCase();
		switch (current)
		{
			default:
			case "android":
				elemento[0] = propiedades[0];
				elemento[1] = propiedades[1];
				break;
			case "ios":
				elemento[0] = propiedades[2];
				elemento[1] = propiedades[3];
				break;		
		}
		return elemento;
	}
	
	/***
	 * Determina si es Android
	 */
	public boolean isAndroid()
	{
		return getConexionAppium().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android");
	}
	
	/***
	 * Determina si es iOS
	 */
	public boolean isIOS()
	{
		return getConexionAppium().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("ios");
	}
	
	/***
	 * Metodo para sustituir el Thread.sleep()
	 * @param tiempoEspera tiempo el cual se desea esperar
	 */
	public void falsoSleep (int tiempoEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), tiempoEspera);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("falsoSleep")));
		}catch (Exception ex) {
			//Accion a realizar
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void swipe (int inicialx, int inicialy, int finx, int finy) {
		new TouchAction((PerformsTouchActions) conexionAppium).longPress(
				new PointOption<>().withCoordinates(inicialx,inicialy)).
		moveTo(new PointOption<>().withCoordinates(finx,finy)).release().perform();
	}
	
	@SuppressWarnings("rawtypes")
	public void longPress (int x, int y,long duracion) 
	{
		Duration duracion2 = Duration.ofMillis(duracion);
		LongPressOptions lpo = new LongPressOptions();
		lpo.withPosition(new PointOption<>().withCoordinates(x,y));
		lpo.withDuration(duracion2);
		new TouchAction((PerformsTouchActions) conexionAppium).longPress(lpo).perform().release();
	}
	
	@SuppressWarnings("rawtypes")
	public void press (int x, int y) 
	{
		new TouchAction((PerformsTouchActions) conexionAppium).press(new PointOption<>().withCoordinates(x,y)) .perform().release();
	}
	
	@SuppressWarnings("rawtypes")
	public void tap (int x, int y)
	{
		new TouchAction((PerformsTouchActions) conexionAppium).tap(new TapOptions().withPosition(new PointOption<>().withCoordinates(x,y))) .perform().release();
	}
	
	@SuppressWarnings("rawtypes")
	public void tap (WebElement elemento)
	{
		int x = elemento.getLocation().getX() + (elemento.getSize().getWidth() / 2);
		int y = elemento.getLocation().getY()  + (elemento.getSize().getHeight() / 2);
		new TouchAction((PerformsTouchActions) conexionAppium).tap(new TapOptions().withPosition(new PointOption<>().withCoordinates(x,y))) .perform().release();
	}
	
	@SuppressWarnings("unchecked")
	public AndroidDriver<AndroidElement> getAndroidDriver()
	{
		return (AndroidDriver<AndroidElement>) ((WebDriverFacade) getDriver()).getProxiedDriver();
	}
	
	
	@SuppressWarnings("unchecked")
	public IOSDriver<IOSElement> getIosDriver()
	{
		return (IOSDriver<IOSElement>) ((WebDriverFacade) getDriver()).getProxiedDriver();
	}
	
	public void obtenerTodoLosObjetos()
	{
		List<MobileElement> elementos = conexionAppium.findElementsByXPath("//*");
		for(MobileElement el : elementos)
		{
			logger.info(el.getText());
		}
	}
	
	public String obtenerUDID()
	{
		return getAndroidDriver().getCapabilities().getCapability("udid").toString();
	}
}