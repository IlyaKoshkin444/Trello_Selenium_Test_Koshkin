package com.telran.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;


public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }


    public void fillLoginForm() throws InterruptedException {
        InitLogin();
        Type(By.id("user"), "eliyahu.kosh44@gmail.com");
        pause(10000);
        clickLogin("login");
        clickLogin("login-submit");
        Type(By.id("password"), "trel23081967");
        clickLogin("login-submit");
        pause(20000);
    }

    public void clickLogin(String login) {
        wd.findElement(By.id(login)).click();
    }

    public void InitLogin() {
        wd.findElement(By.cssSelector("[href='/login']")).click();
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isPassword() {
        return wd.findElement(By.id("password")).isDisplayed();
    }

    public void logout() throws InterruptedException {

        click(By.cssSelector("[data-test-id='header-member-menu-button']"));

        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        pause(15000);
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }


    public void openProfileAndVisibility() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void openAndSwitchToAtlassianProfile() throws InterruptedException {
        click(By.cssSelector("[href $=manage-profile]"));
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }

    }

    public void addPictureAndCloseWindow(ApplicationManager app) throws InterruptedException {
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']")));
        pause(5000);
        app.takeScreenshot();
        click(By.cssSelector("[data-test-selector='profile-hover-info']"));
        if (isElementPresent(By.cssSelector("[role='menu']"))) {
            click(By.xpath("//*[@role='menu']//span[@role='menuitem'][1]"));
        }
        attachFile(By.id("image-input"), new File("/Users/macbookpro/Documents/GitHub/Trello_Selenium_Test_Koshkin_App/src/test/screenshots/cat1.png"));
        click(By.xpath("//*[contains(text(),'Upload')]"));
        pause(5000);
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-header-image']")));
        click(By.cssSelector("[data-test-selector='profile-header-image']"));
        if (isElementPresent(By.cssSelector("[role='menu']"))) {
            click(By.xpath("//*[@role='menu']//span[@role='menuitem'][1]"));
        }
        attachFile(By.cssSelector("[type='file']"), new File("/Users/macbookpro/Documents/GitHub/Trello_Selenium_Test_Koshkin_App/src/test/screenshots/cat2.png"));
       // click(By.xpath("//*[contains(text(),'Upload')]"));
        pause(5000);
        app.takeScreenshot();
        wd.close();
        pause(3000);
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(0));
            pause(5000);
            wd.navigate().refresh();
            pause(5000);
        }
    }

    private void attachFile(By locator, File file) {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
        try {
            pause(10000);

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}