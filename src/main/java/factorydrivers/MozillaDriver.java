package factorydrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaDriver implements DriverSelenium{
    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver","/home/zeta/Downloads/browserDrivers/geckodriver-v0.32.0-linux-aarch64/geckodriver");
        return new FirefoxDriver();
    }
}
