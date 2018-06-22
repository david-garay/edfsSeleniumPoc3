//Info: When you write your code IntelliJ automatically adds required classes
//Also you can select and add required classes by pressing ALT+Enter then select related class
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by ONUR BASKIRT on 26.08.2015.
 */
public class FirstAutomationTest {

    //We should add @Test annotation that JUnit will run below method
    @Test
    //Start to write our test method. It should ends with "Test"
    public void firefoxTest(){

        //Kerberos test
        FirefoxProfile ffprofile = new FirefoxProfile();
        String sitelist = "internal.epo.com, http://edfs-t.internal.epo.org";
        ffprofile.setPreference("browser.tabs.remote.force-enable",true);
        ffprofile.setPreference("network.negotiate-auth.trusted-uris", sitelist);
        ffprofile.setPreference("network.negotiate-auth.delegation-uris", sitelist);
        ffprofile.setPreference("network.automatic-ntlm-auth.trusted-uris", sitelist);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(ffprofile);

        //Step 1- Driver Instantiation: Instantiate driver object as FirefoxDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();


        //Step 2- Navigation: Open a website
        driver.navigate().to("http://edfs-t.internal.epo.org/rcedossier/#/workspace/EPA16189692/analyse/(first/wholedocument//second:second/)");

        //Step 3- Assertion: Check its title is correct
        //assertEquals method Parameters: Message, Expected Value, Actual Value
        Assert.assertEquals("Title check failed!", "EPA 16189692", driver.getTitle());

        //Step 4- Close Driver
        driver.close();

        //Step 5- Quit Driver
        driver.quit();
    }
}