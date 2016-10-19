package com.kasisripriyawebapps.myindia.util;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;;

public class LocationUtil {

	static WebDriver driver;
	static Wait<WebDriver> wait;
	static String baseUrl = "http://lgdirectory.gov.in/";

	static {
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");

		System.setProperty("http.proxyHost", "proxy.cat.com");
		System.setProperty("http.proxyPort", "80");

		System.setProperty("https.proxyHost", "proxy.cat.com");
		System.setProperty("https.proxyPort", "80");

	}

	public static void loadMainPage() throws InterruptedException {
		driver.get(baseUrl);

	}

	public static void clickDownLoadDirectoryLink() {
		WebElement quickAccessDivTag = driver.findElement(By.className("quick-access"));
		List<WebElement> quickAccessLinks = quickAccessDivTag.findElements(By.tagName("a"));
		quickAccessLinks.get(1).click();
	}

	public static void clickElementById(String id) {
		WebElement quickAccessDivTag = driver.findElement(By.id(id));
		Actions actions = new Actions(driver);
		actions.moveToElement(quickAccessDivTag).click().perform();

	}

	public static void clickRadioElementByNameAndId(String name, String id) {
		By byCss = By.cssSelector("[name=" + name + "][id=" + id + "][type='radio']");
		driver.findElement(byCss).click();
	}

	public static void clickDropDownOption(String selectBoxId, String optionName) {
		Select dropdown = new Select(driver.findElement(By.id(selectBoxId)));
		dropdown.selectByVisibleText(optionName);
	}

	public static String getImageSourceById(String id) {
		WebElement quickAccessDivTag = driver.findElement(By.id(id));
		String imageSrc = quickAccessDivTag.getAttribute("src");
		return imageSrc;
	}

	public static void downloadImageSourceById(String id) throws InterruptedException, AWTException {
		WebElement quickAccessDivTag = driver.findElement(By.id(id));
		Actions action = new Actions(driver);
		action.contextClick(quickAccessDivTag).build().perform();
		action.sendKeys("v").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.CONTROL, "v").build().perform();
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public static String callURL(String serviceUrl) throws MalformedURLException, IOException {
		String urlResponse = null;
		InputStream input = new URL(serviceUrl).openStream();
		byte[] byteArray = IOUtils.toByteArray(input);
		byte[] bytes64 = Base64.encodeBase64(byteArray);
		urlResponse = new String(bytes64);
		return urlResponse;
	}

	public static String getImageData(String urlResponse) throws InternalServerException, IOException {
		System.out.println(urlResponse);
		File captchaFile = new File(
				CommonUtil.getImageLocation(urlResponse, ServiceConstants.CAPTCHA_LOCATION_FILE_NAME));
		String captchFileName = captchaFile.getAbsolutePath();
		BytePointer outText;
		TessBaseAPI api = new TessBaseAPI();
		if (api.Init(
				"C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\Eclipse WorkSpace\\GIT Repository\\MyIndia\\",
				"ENG") != 0) {

			System.exit(1);
		}
		// Open input image with leptonica library
		PIX image = pixRead(captchFileName);
		api.SetImage(image);
		// Get OCR result
		outText = api.GetUTF8Text();
		String captcha = outText.getString();
		captcha = CommonUtil.getFinalCaptcha(captcha);
		api.End();
		outText.deallocate();
		pixDestroy(image);

		return captcha;

	}

	private static void fillText(String textBoxId, String textToEnter) {
		WebElement textBox = driver.findElement(By.id(textBoxId));
		textBox.sendKeys(textToEnter);
	}

	private static void copyText(String textBoxId) {
		WebElement textBox = driver.findElement(By.id(textBoxId));
		textBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		textBox.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

	public static void main(String[] args)
			throws InterruptedException, InternalServerException, MalformedURLException, IOException, AWTException {

		String downloadFilepath = "C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\Eclipse WorkSpace\\GIT Repository\\MyIndia";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		String captchFileName = "C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\Eclipse WorkSpace\\GIT Repository\\MyIndia\\LocationCaptchaImg.png";

		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		loadMainPage();
		clickDownLoadDirectoryLink();
		clickElementById("DFDOption");
		clickDropDownOption("rptFileName", "All States of India");
		Thread.sleep(4000);
		clickElementById("downloadType3");
		fillText("captchaAnswer", captchFileName);
		copyText("captchaAnswer");
		Thread.sleep(4000);
		downloadImageSourceById("captchaImageId");
		Thread.sleep(4000);
		/*
		 * String captchaSrc = getImageSourceById("captchaImageId"); String
		 * urlResponse = callURL(captchaSrc); String captchaResponse =
		 * getImageData(urlResponse); System.out.println(captchaResponse);
		 */

		fillText("captchaAnswer", "sdsd");
	}

}
