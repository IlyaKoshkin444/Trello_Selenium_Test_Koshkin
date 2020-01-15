package com.telran.trello.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateTeamsTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditionsTestCreateTeams() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().fillLoginForm();
        }
    }

   @Test
   public void testCreateTeams () throws InterruptedException {
       int before = app.getTeam().getTeamsCount();

       app.getTeam().clickPlusTeamButton();
       app.getTeam().inputCreateTeamTitle();
       app.getTeam().inputCreateTeamDescription();
       app.getTeam().clickCreateTeamSubmitButton();
       app.getTeam().inviteTeamMembers();
       app.getBoard().returnToHomePage();

       int after = app.getTeam().getTeamsCount();
       Assert.assertEquals(after, before +1 );
       System.out.println("Count Teams after create is: " + after );
   }

    @AfterClass
    public void postActions() throws InterruptedException {
        int teamsCount =  app.getTeam().getTeamsCount();
        while (teamsCount>4){
            app.getTeam().deleteTeam();
            teamsCount =  app.getTeam().getTeamsCount();
        }


    }

}
