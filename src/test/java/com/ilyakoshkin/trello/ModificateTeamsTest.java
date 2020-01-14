package com.ilyakoshkin.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModificateTeamsTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditionsTestModificateTeams() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            fillLoginForm();
        }
    }
    @Test
    public void testModificateTeams () throws InterruptedException {


        clickChoiceTeam();
        clickSettings();
        clickEditTeamProfile();
        editNameAndDescriptionTeam();
        clickSaveEditTeamProfile();
        returnToHomePage1();
    }


}
