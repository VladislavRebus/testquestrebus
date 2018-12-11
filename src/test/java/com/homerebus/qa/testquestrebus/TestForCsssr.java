package com.homerebus.qa.testquestrebus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestForCsssr {
    WebDriver webDriver;

    @BeforeClass
    public void initializationDriver() {
        System.out.println("Тестируем в Google Chrome");
        System.setProperty("webdriver.chrome.driver", "D:\\dom\\testquestrebus\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void openAdress() {
        webDriver.manage().window().maximize();
        webDriver.get("http://blog.csssr.ru/qa-engineer/");
    }

    @Test
    public void testCheckBox() throws InterruptedException {
        WebElement element1 = webDriver.findElement(By.xpath("/html/body/div[1]/section[1]/section/div[2]/a"));
        //поиск элемента "находить несовершенства"
        element1.click(); //жмем на элемент

        //проскролим чтобы были видны выбранные чекбоксы (4 штуки)
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,500)", "");

        //Сделаем небольшую задержку для наглядности
        Thread.sleep(4000);

        //ищем чекбоксы и кликаем,чтобы снять выделение.
        WebElement checkbox1 = webDriver.findElement(By.xpath("/html/body/div[1]/section[2]/div[2]/aside/ul/li[1]/label"));
        checkbox1.click();
        WebElement checkbox2 = webDriver.findElement(By.xpath("/html/body/div[1]/section[2]/div[2]/aside/ul/li[2]/label"));
        checkbox2.click();
        WebElement checkbox3 = webDriver.findElement(By.xpath("/html/body/div[1]/section[2]/div[2]/aside/ul/li[3]/label"));
        checkbox3.click();
        WebElement checkbox4 = webDriver.findElement(By.xpath("/html/body/div[1]/section[2]/div[2]/aside/ul/li[4]/label"));
        checkbox4.click();

        //небольшая задержка до закрытия , для визуального подтверждения наличия кликабельных чекбоксов
        Thread.sleep(1000);
    }

    @AfterClass
    public void closeDriver() {
        webDriver.close();
    }
}
    //Можно было бы попробовать сделать с применением ассертов, но думаю данных действий достаточно чтобы убедиться,
// что чекбоксы кликабельны. В нашем случае это недопустимо, так как исходный макет не предполагает такую функциональность.

// Тест подтверждает наличие кликабельных чекбоксов.