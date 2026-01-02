package OrangeHRMTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee {
	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        try {
        	driver.get("https://opensource-demo.orangehrmlive.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            //waits until the element is visible on page
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

            usernameField.sendKeys("Admin");
            passwordField.sendKeys("admin123");
            loginButton.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-topbar-header-title")));
            System.out.println("Login successful!");
            
            WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));
            pimMenu.click();
            
            WebElement add = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add Employee']")));
            add.click();
            
            WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
            firstname.sendKeys("Soni");
            
            WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
            lastname.sendKeys("ma");
            
            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type = 'submit']")));
            submit.click();
            System.out.println("Successfuly saved");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}
}