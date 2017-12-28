package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver d){
        driver = d;
        PageFactory.initElements(d, this);
    }

    public void takeScreenShoot(String Name) throws Exception{
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("ScreenShoots\\" + Name + ".png"));
    }
}
