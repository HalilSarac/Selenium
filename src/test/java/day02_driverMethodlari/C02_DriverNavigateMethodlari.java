package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

         System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
         WebDriver driver = new ChromeDriver();

         driver.navigate().to("https://testotomasyonu.com");
         // driver.get(istenenUrl) ile aynı işlemi yapar

         // youtube anassayfaya gidin
         driver.navigate().to("https://youtube.com/");

         // title'in "YoutTube" içerdiğini test edin
         String actualTitle = driver.getTitle();
         String expectedTitle = "YouTube";

         if (actualTitle.contains(expectedTitle)){
             System.out.println("Youtube title testi PASSED");
         }else {
             System.out.println("Youtube title testi FAILED");
         }

         // tekrar test otomasyonu ana sayfaya dönün
         driver.navigate().back();

         // sayfa kaynağının "Test Otomasyonu" içerdiğini test edin
         String actualSayfaIcerik = driver.getPageSource();
         String expectedSayfaKaynagi = "Test Otomasyonu";

        if (actualSayfaIcerik.contains(expectedSayfaKaynagi)){
            System.out.println("Test otomasyonu sayfa içeriği testi PASSED");
        }else {
            System.out.println("Test otomasyonu sayfa içeriği testi FAILED");
        }

         // bir daha youtube anasayfaya gidin
         driver.navigate().forward();

         // url'in https://www.youtube.com/ olduğunu test edin
         String actualUrl = driver.getCurrentUrl();
         String expectedUrl = "https://www.youtube.com/";

         if (actualUrl.equals(expectedUrl)){
             System.out.println("Youtube Url testi PASSED");
         }else {
             System.out.println("Youtube Url testi FAILED");
         }

         Thread.sleep(3000);
         driver.quit();
    }
}
