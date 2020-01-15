package com.telran.trello.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTeamsTest extends  TestBase{

    @BeforeMethod
    public void ensurePreconditionsTestDeleteTeams() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().fillLoginForm();
        }
    }

    @Test
    public void testDeleteTeams () throws InterruptedException {
        int before = app.getTeam().getTeamsCount();

        app.getTeam().clickChoiceTeam();
        app.getTeam().clickSettings();
        app.getTeam().clickDeleteThisTeam();
        app.getTeam().clickConfirmDeleteTeam();

        int after = app.getTeam().getTeamsCount();
        Assert.assertEquals(after, before -1 );
        System.out.println("Count Teams after delete is: " + after );
    }


}
