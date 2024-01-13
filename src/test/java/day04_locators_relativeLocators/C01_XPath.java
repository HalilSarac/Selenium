package day04_locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_XPath {

    public static void main(String[] args) throws InterruptedException {

        //1- bir class oluşturun
        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get(" https://www.testotomasyonu.com/");

        //3- Browseri tam sayfa yapın
        driver.manage().window().maximize();

        //4- Sasyfayi "refresh" yapın
        driver.navigate().refresh();

        //5- Sayfa başlığının "Test Otomasyonu" ifadesi içerdiğini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title içerik testi PASSED");
        }else {
            System.out.println("Title içerik testi FAILED");
        }

        //6- Furniture linkine tıklayın
        driver.findElement(By.xpath("//li[@class='has-sub'][5]")).click();

        //7- price range filtresinde min değere 40, max değere 200 yazip filtreleyin
        WebElement minDegerKutusu = driver.findElement(By.xpath("//input[@name='min']"));
        minDegerKutusu.clear();
        minDegerKutusu.sendKeys("40");

        WebElement maxDegerKutusu = driver.findElement(By.xpath("//input[@name='max']"));
        maxDegerKutusu.clear();
        maxDegerKutusu.sendKeys("200");

        driver.findElement(By.xpath("//button[@class='price-range-button']")).click();

        //8- filtreleme sonucunda ürün bulunabildiğini test edin
        List<WebElement> bulunanUrunlerListesi
                = driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int actualBulunanUrunsayisi = bulunanUrunlerListesi.size();

        if (actualBulunanUrunsayisi > 0){
            System.out.println("Bulunan urun testi PASSED");
        }else {
            System.out.println("Bulunan ürün testi FAILED");
        }

        //9- Ilk ürüne tıklayın
        bulunanUrunlerListesi.get(0).click();

        //10-Urün fiyatının 40 ile 200 arasında olduğunu test edin
        WebElement urunFiyatElementi = driver.findElement(By.xpath("//span[@id='priceproduct']"));

        String urunFiyatiStr = urunFiyatElementi.getText().replaceAll("\\D","");
        int urunFiyatiInt = Integer.parseInt(urunFiyatiStr)/100;

        if (urunFiyatiInt > 40 && urunFiyatiInt < 200){
            System.out.println("İlk ürün fiyat testi PASSED");
        }else {
            System.out.println("İlk ürün fiyat testi FAILED");
        }

        //11-Sayfayı kapatın
        Thread.sleep(3000);
        driver.quit();
    }
}
