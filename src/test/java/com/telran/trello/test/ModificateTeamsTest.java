package com.telran.trello.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModificateTeamsTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditionsTestModificateTeams() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().fillLoginForm();
        }
    }
    @Test
    public void testModificateTeams () throws InterruptedException {


        app.getTeam().clickChoiceTeam();
        app.getTeam().clickSettings();
        app.getTeam().clickEditTeamProfile();
        app.getTeam().editNameAndDescriptionTeam();
        app.getTeam().clickSaveEditTeamProfile();
        app.getTeam().returnToHomePage1();
    }


}
