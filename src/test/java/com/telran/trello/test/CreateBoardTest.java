package com.telran.trello.test;

import com.telran.trello.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateBoardTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validBoards() {
        List<Object[]> list =new ArrayList<>();
        list.add(new Object[]{"nameBoard1"});
        list.add(new Object[]{"Bn"});
        list.add(new Object[]{"BoardNameWithDataProvider2"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validBoardsCSV() throws IOException {
        List<Object[]> list =new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/boardsPositiveCSV.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]split = line.split(",");
            list.add(new Object[]{new BoardData().setBoardName(split[0])});
            line = reader.readLine();
        }
        return list.iterator();
    }

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
        app.getBoard().inputCreateBoardTitle(new BoardData().setBoardName("boardName"));
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

    @Test(dataProvider = "validBoards")
    public void testCreateBoardWithDP (String boardName) throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().clickPlusButton();
        app.getBoard().clickCreateBoardButton();
        app.getBoard().inputCreateBoardTitle(new BoardData().setBoardName(boardName));
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

    @Test(dataProvider = "validBoardsCSV")
    public void testCreateBoardWithCSV (BoardData board) throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().clickPlusButton();
        app.getBoard().clickCreateBoardButton();
        app.getBoard().inputCreateBoardTitle(board);
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