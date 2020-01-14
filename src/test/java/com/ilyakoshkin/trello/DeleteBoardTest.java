package com.ilyakoshkin.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsTestDeleteBoard() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            fillLoginForm();
        }
    }

    @Test
    public void testDeleteBoard() throws InterruptedException {
        int before = getBoardsCount();

        clickIconBoard();
        if(isHeaderMenuPresent()) { clickBoardHeaderMenu();}
        if(isBoardMenuBackButtonPresent()) { clickBoardMenuBackButton();}
        /*else {
            if (!isBoardMenuBackButtonPresent()) {
            } else {
            clickBoardMenuBackButton();}
        }*/
        clickBoardMenuOpenMore();
        clickBoardMenuCloseBoard();
        clickConfirmCloseBoard();
        clickPermanentlyDeleteBoard();
        clickConfirmPermanentlyDeleteBoard();
        returnToHomePage();

        int after = getBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("Count Boards after delete is: " + after);
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

}
