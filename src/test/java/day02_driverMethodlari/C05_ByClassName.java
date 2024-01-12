package day02_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER); // aramaKutusu.submit();

        // arama sonucundan bulunan elementlerin isimlerini yazdırın
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//a[@class = 'prod-title mb-3 ']"));
        /*
            Locate etmek için By.className methodu kullandığımızda
            HTML element'deki class attribute'unun değerinde
            space varsa
            By.classname() çalışmayabilir
         */

        // liste WebElement'lerden oluştuğu için
        // listeyi direk yazdırırsak, elementlerin referanslarını yazdırır

        for (WebElement each: bulunanUrunElementleriList
            ){
            System.out.println(each.getText());
        }

        // arama sonucunda 4 ürün bulunabildiğini test edin
        int expectedUrunSayisi = 4;
        int actualUrunSayisi = bulunanUrunElementleriList.size();

        if (expectedUrunSayisi == actualUrunSayisi){
            System.out.println("Phone arama urun sayi testi PASSED");
        }else {
            System.out.println("Phone arama ürün sayi testi FAILED");
        }

        // ilk ürün isminde phone casesensitive geçtiğini test edin
        String actualIlkUrunIsmi = bulunanUrunElementleriList.get(0).getText().toLowerCase();
        String expectedIlkUrunIcerik = "phone";

        if (actualIlkUrunIsmi.contains(expectedIlkUrunIcerik)){
            System.out.println("Ilk ürün isim testi PASSED");
        }else {
            System.out.println("Ilk ürün isim testi FAILED");
        }

        // sayfayi kapatın
        Thread.sleep(3000);
        driver.quit();

    }
}