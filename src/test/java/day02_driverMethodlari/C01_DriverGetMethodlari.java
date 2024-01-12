package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testotomasyonu.com");

        // Acilan sayfanın Title'inda 'otomasyon' geçtiğini test ediniz

        String actualTitle = driver.getTitle();
        String expectedTitle = "Test Otomasyonu - Test Otomasyonu";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
        }



        // acilan sayfanin url'inin otomasyon içerdeiğini test edin

        String expedtedUrlIcerik = "otomasyon";
        String actualUrl = driver.getCurrentUrl();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi FAILED");
        }
        /*
        driver.getWindowHandle(); driver'ın gittiği sayfanın Windowhandle değerini verir
        driver.getWindowHandles(); driver oluşturulduktan sonra, test boyunca
                                   açtığı tüm sayfaların WindowHandle değerlerini bir set olarak verir
         */

        System.out.println(driver.getWindowHandle());
        // 6974B85263CF39B6B1AABC423EE5B508
        System.out.println(driver.getWindowHandles());
        // [6974B85263CF39B6B1AABC423EE5B508]

        System.out.println("================= Sayfa Kaynagi =====================");
        System.out.println(driver.getPageSource());
        // tüm sayfa kaynağını döndürür,
        // sayfa kaynağı ile ilgili bir test istenilirse kaydedilip kullanılabilir



        Thread.sleep(3000); // java'dan gelir kodlari yazilan milisaniye kadar bekletir
        driver.quit();
    }
}
