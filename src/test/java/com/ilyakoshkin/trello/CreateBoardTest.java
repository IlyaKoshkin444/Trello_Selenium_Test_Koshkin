package com.ilyakoshkin.trello;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsTestCreateBoard() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            fillLoginForm();
        }

    }

    @Test
    public void testCreateBoard () throws InterruptedException {
        int before = getBoardsCount();
        clickPlusButton();
        clickCreateBoardButton();
        inputCreateBoardTitle();
        selectCreateBoardFromDropDownNoteam();
        selectCreateBoardFromDropDownPrivatePublic();
        clickCreateBoardPublic();
        clickConfirmMakeBoardPublicButton();
        clickConfirmCreateBoardButton();
        returnToHomePage();


        int after = getBoardsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("Count Boards after create is: " + after);
    }
    @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount =  getBoardsCount();
        while (boardsCount>4){
            deleteBoard();
            boardsCount =  getBoardsCount();
        }



    }

}