package factorydrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromerDriver implements DriverSelenium{
    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/zeta/Downloads/browserDrivers/chromedriver_linux64/chromedriver");

        return new ChromeDriver();
    }
}
