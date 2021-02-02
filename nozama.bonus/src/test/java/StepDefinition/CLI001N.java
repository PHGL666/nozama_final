package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.Disconnection;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CLI001N {
	WebDriver driver;

	@After
	public void disconnect() {
		Disconnection.disconnect(driver);
	}
	
	@Given("^navigateur Chrome ouvert et application sur homepage$")
	public void navigateur_Chrome_ouvert_et_application_sur_homepage() /* throws Throwable */ {

		System.out.println("Le navigateur Chrome est ouvert");
		System.setProperty("webdriver.chrome.driver", "S:\\TESTEUR INFORMATIQUE\\7_SELENIUM\\Chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1/nozama");
		{
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'block-user-0\']/div/h2"));
			assert (elements.size() > 0);
		}
	}

	@When("^renseigner username et password$")
	public void renseigner_username_et_password() {
		System.out.println("Login et mot de passe sont renseignes");
		{
			List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-name\']"));
			assert (elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-pass\']"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.xpath("//input[@id=\'edit-name\']")).sendKeys("store1");
		driver.findElement(By.xpath("//input[@id=\'edit-pass\']")).sendKeys("store1");
	}

	@When("^valider le formulaire$")
	public void valider_le_formulaire() {
		System.out.println("Le bouton est clique");
		{
			List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).submit();
	}

	@Then("^verifier que je suis connecte avec login et mdp$")
	public void verifier_que_je_suis_connecte_avec_login_et_mdp() /* throws Throwable */ {
		System.out.println("Je suis sur la bonne page");
		{
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'block-menu-menu-logout\']/div/h2"));
			assert (elements.size() > 0);
		}
	}
}
