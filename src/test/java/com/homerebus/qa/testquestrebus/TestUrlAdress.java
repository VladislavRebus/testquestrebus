package com.homerebus.qa.testquestrebus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestUrlAdress {
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
    public  void findUrl() throws InterruptedException {
        WebElement element1 = webDriver.findElement(By.xpath("/html/body/div[1]/section[1]/section/div[2]/a"));
        //поиск элемента "находить несовершенства"
        element1.click(); //жмем на элемент
        String oldTab = webDriver.getWindowHandle();
        WebElement element2 = webDriver.findElement(By.linkText("Софт для быстрого создания скриншотов"));
        element2.click();
        ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
        newTab.remove(oldTab);
        //фокусировка на новой вкладке
        webDriver.switchTo().window(newTab.get(0));
        // проверим наличие элемента странице
        Assert.assertTrue(webDriver.findElement(By.xpath("/html/body/div[1]/div/div[4]/span/div")).isDisplayed());
        System.out.println("Проверка на загрузку по кнопке: Скачать Lightshot бесплатно  ");

        // Тест подтверждает, наличие адреса на недопустимое ПО в ссылке "Софт для быстрого создания скриншотов"
        // (https://app.prntscr.com/ru/). В соответствии с исходным
        // макетом должен быть (https://monosnap.com/welcome).




    }


}
