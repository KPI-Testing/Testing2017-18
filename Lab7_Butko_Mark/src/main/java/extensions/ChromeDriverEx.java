package extensions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

public class ChromeDriverEx extends ChromeDriver {

    private static ChromeOptions options;

    static{
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
    }

    public ChromeDriverEx() throws Exception {
        super(options);
    }

    public void takeScreenShoot(String Path) throws Exception{
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(this);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File(Path));
    }
}
