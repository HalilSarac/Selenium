package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
            görev odaklıdır sayfanın açılması veya kullanacağımız web elementlerin bulunması için
            bekleyeceği MAXIMUM süredi
         */
        Thread.sleep(3000);
        driver.manage().window().maximize();

        System.out.println("Maximize görünüm size : " + driver.manage().window().getSize());
        System.out.println("Maximize görünüm size : " + driver.manage().window().getPosition());

        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen görünüm size : " + driver.manage().window().getSize());
        System.out.println("Fullscreen görünüm size : " + driver.manage().window().getPosition());

        Thread.sleep(3000);
        driver.manage().window().setPosition(new Point(300,300));
        driver.manage().window().setSize(new Dimension(500,500));
        Thread.sleep(3000);
        System.out.println("Ozel görünüm size : " + driver.manage().window().getSize());
        System.out.println("Ozel görünüm size : " + driver.manage().window().getPosition());

        Thread.sleep(3000); // görev odaklı değildir mutlaka 3 saniye bekler
        driver.quit();
    }
}