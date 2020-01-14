package com.ilyakoshkin.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver wd;


    @BeforeSuite
    public void setUp() {
        String browser =
                System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.SAFARI)) {
            wd = new SafariDriver();
        }

        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        openSite("https://trello.com/ ");
    }

    @AfterSuite
    public void tearDown() {
        wd.quit();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void Type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }
    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }
    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void openSite(String url) {
        wd.get(url);
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

    public void clickConfirmCreateBoardButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        pause(5000);
    }

    public void clickConfirmMakeBoardPublicButton() throws InterruptedException {
        click(By.xpath("//button[@class='_3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA']"));
        pause(5000);
    }

    public void clickCreateBoardPublic() throws InterruptedException {
        click(By.xpath("//div[@class='atlaskit-portal-container']//li[2]//button[1]"));
        pause(5000);
    }

    public void selectCreateBoardFromDropDownPrivatePublic() throws InterruptedException {
        click(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));
        pause(5000);
    }

    public void selectCreateBoardFromDropDownNoteam() throws InterruptedException {
        click(By.xpath("//button[@class='W6rMLOx8U0MrPx']//span[@name='down']"));
        pause(5000);
        click(By.xpath("//span[@class='_1uK2vQ_aMRS2NU']"));
        pause(5000);
    }

    public void inputCreateBoardTitle() {
        Type(By.cssSelector("[data-test-id='create-board-title-input']"), "MyTestBoard");
    }

    public void clickCreateBoardButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
        pause(5000);
    }

    public void clickPlusButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        pause(5000);
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.name("house"));
        pause(10000);
        click(By.name("house"));
        pause(10000);
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void clickConfirmPermanentlyDeleteBoard() throws InterruptedException {
        click(By.xpath("//input[@class='js-confirm full negate']"));
        pause(5000);
    }

    public void clickPermanentlyDeleteBoard() throws InterruptedException {
        click(By.xpath("//a[@class='quiet js-delete']"));
        pause(5000);
    }

    public void clickConfirmCloseBoard() throws InterruptedException {
        click(By.xpath("//input[@class='js-confirm full negate']"));
        pause(5000);
    }

    public void clickBoardMenuCloseBoard() throws InterruptedException {
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']"));
        pause(5000);
    }

    public void clickBoardMenuOpenMore() throws InterruptedException {
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
        pause(5000);
    }

    public void clickBoardMenuBackButton() throws InterruptedException {
        click(By.xpath("//a[@class='board-menu-header-back-button icon-lg icon-back js-pop-widget-view']"));
        pause(10000);
    }

    public void clickIconBoard() throws InterruptedException {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
        pause(5000);
    }

    public void deleteBoard() throws InterruptedException {
        clickIconBoard();
        clickBoardMenuBackButton();
        clickBoardMenuOpenMore();
        clickBoardMenuCloseBoard();
        clickConfirmCloseBoard();
        clickPermanentlyDeleteBoard();
        clickConfirmPermanentlyDeleteBoard();
        returnToHomePage();

    }

    public void inviteTeamMembers() throws InterruptedException {
        Type(By.cssSelector("[class='autocomplete-input']"), "xyz444@pochta.com");
        click(By.cssSelector("[class='autocomplete-btn primary fullWidthButton']"));
        pause(5000);
    }

    public void clickCreateTeamSubmitButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
        pause(5000);
    }

    public void inputCreateTeamDescription() throws InterruptedException {
      Type(By.cssSelector("[id$=description]"), "Example for QA-22-Team");
        pause(5000);
    }

    public void inputCreateTeamTitle() throws InterruptedException {
        Type(By.cssSelector("[data-test-id='header-create-team-name-input']"), "QA-22-Team");
        pause(5000);
    }

    public void clickPlusTeamButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
        pause(5000);
    }

    public int getTeamsCount() {
        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size();
    }

    public void clickConfirmDeleteTeam() throws InterruptedException {
        click(By.xpath("//input[@class='js-confirm full negate']"));
        pause(5000);
    }

    public void clickDeleteThisTeam() throws InterruptedException {
        click(By.cssSelector("[class='quiet-button']"));
        pause(5000);
    }

    public void clickSettings() throws InterruptedException {
        click(By.cssSelector("[class^=icon-gear]"));
        pause(5000);
    }

    public void clickChoiceTeam() throws InterruptedException {
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
        pause(5000);

    }

    public void deleteTeam() throws InterruptedException {
        clickChoiceTeam();
        clickSettings();
        clickDeleteThisTeam();
        clickConfirmDeleteTeam();
    }

    public void returnToHomePage1() throws InterruptedException {
        click(By.name("house"));
        pause(5000);
        click(By.cssSelector("[data-test-id='home-link']"));
        pause(5000);
    }

    public void clickSaveEditTeamProfile() throws InterruptedException {
        click(By.xpath("//input[@class='primary wide js-submit-profile']"));
        pause(5000);
    }

    public void editNameAndDescriptionTeam() {
        Type(By.xpath("//input[@name='displayName']"), "QA-22 TEAM PROFESSIONAL");
        Type(By.xpath("//textarea[@name='desc']"), "Example for QA-22 TEAM PROFESSIONAL");
    }

    public void clickEditTeamProfile() throws InterruptedException {
        click(By.xpath("//a[@class='button-link tabbed-pane-header-details-edit js-edit-profile']"));
        pause(5000);
    }
}