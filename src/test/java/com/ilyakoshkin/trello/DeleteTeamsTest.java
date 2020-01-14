package com.ilyakoshkin.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTeamsTest extends  TestBase{

    @BeforeMethod
    public void ensurePreconditionsTestDeleteTeams() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            fillLoginForm();
        }
    }

    @Test
    public void testDeleteTeams () throws InterruptedException {
        int before = getTeamsCount();

        clickChoiceTeam();
        clickSettings();
        clickDeleteThisTeam();
        clickConfirmDeleteTeam();

        int after = getTeamsCount();
        Assert.assertEquals(after, before -1 );
        System.out.println("Count Teams after delete is: " + after );
    }


}
