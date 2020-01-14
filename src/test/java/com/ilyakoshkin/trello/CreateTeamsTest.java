package com.ilyakoshkin.trello;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateTeamsTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditionsTestCreateTeams() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            fillLoginForm();
        }
    }

   @Test
   public void testCreateTeams () throws InterruptedException {
       int before = getTeamsCount();

       clickPlusTeamButton();
       inputCreateTeamTitle();
       inputCreateTeamDescription();
       clickCreateTeamSubmitButton();
       inviteTeamMembers();
       returnToHomePage();

       int after = getTeamsCount();
       Assert.assertEquals(after, before +1 );
       System.out.println("Count Teams after create is: " + after );
   }

    @AfterClass
    public void postActions() throws InterruptedException {
        int teamsCount =  getTeamsCount();
        while (teamsCount>4){
            deleteTeam();
            teamsCount =  getTeamsCount();
        }


    }

}
