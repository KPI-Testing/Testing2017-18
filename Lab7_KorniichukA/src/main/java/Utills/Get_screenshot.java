package Utills;

        import org.apache.commons.io.FileUtils;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.WebDriver;

        import java.io.File;

public class Get_screenshot {
    public static void getscreenshot(WebDriver driver) throws Exception
    {
        File screenFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenFile, new File("D:\\Аня\\3-й курс\\тестування\\Lab7_KorniichukA\\Screen\\Screen.png"));
    }
}