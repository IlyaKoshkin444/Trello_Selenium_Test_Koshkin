package com.telran.trello.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsTestCreateBoard() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().fillLoginForm();
        }

    }

    @Test
    public void testCreateBoard () throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().clickPlusButton();
        app.getBoard().clickCreateBoardButton();
        app.getBoard().inputCreateBoardTitle();
        app.getBoard().selectCreateBoardFromDropDownNoteam();
        app.getBoard().selectCreateBoardFromDropDownPrivatePublic();
        app.getBoard().clickCreateBoardPublic();
        app.getBoard().clickConfirmMakeBoardPublicButton();
        app.getBoard().clickConfirmCreateBoardButton();
        app.getBoard().returnToHomePage();


        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("Count Boards after create is: " + after);
    }
    @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount =  app.getBoard().getBoardsCount();
        while (boardsCount>4){
            app.getBoard().deleteBoard();
            boardsCount =  app.getBoard().getBoardsCount();
        }



    }

}