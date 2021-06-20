package AppiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    static AppiumDriver<MobileElement> appiumDriver;

    public static void main(String[] args) {
        try {
            openCalculator();
        } catch (Exception exception) {
            System.out.println(exception.getCause());
            System.out.println(exception.getMessage());
            exception.printStackTrace();

        }
    }

    public static void openCalculator() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Redmi Note 5 Pro");
        capabilities.setCapability("udid", "192.168.8.227:5555");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("appPackage", "com.miui.calculator");
        capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AppiumDriver<MobileElement>(url, capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Allowing permission for the app -> clicking "agree" button
        appiumDriver.findElement(By.id("android:id/button1")).click();

        MobileElement two = appiumDriver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
        MobileElement five = appiumDriver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
        MobileElement plus = appiumDriver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
        MobileElement equals = appiumDriver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
        MobileElement result = appiumDriver.findElement(By.className("android.widget.TextView"));

        two.click();
        plus.click();
        five.click();
        equals.click();
        System.out.println("Result : " + result.getText());

    }

}
