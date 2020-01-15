package com.telran.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
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

    public boolean isBoardMenuBackButtonPresent() {
        return isElementPresent(By.xpath("//a[@class='board-menu-header-back-button icon-lg icon-back js-pop-widget-view']"));
    }

    public boolean isHeaderMenuPresent() {
        return isElementPresent(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']"));
    }

    public void clickBoardHeaderMenu() throws InterruptedException {
        click(By.xpath("//span[@class='icon-sm icon-overflow-menu-horizontal board-header-btn-icon']"));
        pause(10000);
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.name("house"));
        pause(10000);
        click(By.name("house"));
        pause(10000);
    }
}
