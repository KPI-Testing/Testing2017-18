package utillites;

import extentions.ChromeDriverEx;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class screenshot {
    public static void getscreenshot(WebDriver driver) throws Exception
    {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("C:\\Users\\Trokhymovych\\IdeaProjects\\Lab7_TrokhymovychMykola\\screenshot\\screenshot.png"));
    }
}
