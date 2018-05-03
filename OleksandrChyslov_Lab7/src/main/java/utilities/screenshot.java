package utilities;

import extensions.ChromeDriverEx;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
public class screenshot {
    //protected static ChromeDriverEx driver;
    public static void takeScreenshot(ChromeDriverEx driverx)throws Exception
    {
        File scrFile = driverx.getFullScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("././././Screenshots/"+ "screenshot" + ".png"));
        } catch (IOException e){
            System.out.println("IOException while saving screenshot!");
        }
    }
}




