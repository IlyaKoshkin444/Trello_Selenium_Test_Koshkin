package com.telran.trello.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsTestDeleteBoard() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().fillLoginForm();
        }
    }

    @Test
    public void testDeleteBoard() throws InterruptedException {
        int before = app.getBoard().getBoardsCount();

        app.getBoard().clickIconBoard();
        if (app.getBoard().isHeaderMenuPresent()) {
            app.getBoard().clickBoardHeaderMenu();
        }
        if (app.getBoard().isBoardMenuBackButtonPresent()) {
            app.getBoard().clickBoardMenuBackButton();
        }
        app.getBoard().clickBoardMenuOpenMore();
        app.getBoard().clickBoardMenuCloseBoard();
        app.getBoard().clickConfirmCloseBoard();
        app.getBoard().clickPermanentlyDeleteBoard();
        app.getBoard().clickConfirmPermanentlyDeleteBoard();
        app.getBoard().returnToHomePage();


        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("Count Boards after delete is: " + after);
    }

}
