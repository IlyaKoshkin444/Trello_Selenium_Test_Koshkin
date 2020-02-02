package com.telran.trello.test;
import com.telran.trello.model.TeamData;
import com.telran.trello.util.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ModificateTeamsTest extends TestBase{


    @BeforeMethod
    public void ensurePreconditionsTestModificateTeams() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().fillLoginForm();
        }
    }

    @Test(dataProvider = "validTeams",dataProviderClass = DataProviders.class)
    public void testModificateTeamsWithDP (String name, String description) throws InterruptedException {

        app.getTeam().clickChoiceTeam();
        app.getTeam().clickSettings();
        app.getTeam().clickEditTeamProfile();
        //app.getTeam().clickChooceTeamTypeDropDown();
        app.getTeam().editNameAndDescriptionTeam(new TeamData().setName(name).setDescription(description));
        app.getTeam().clickSaveEditTeamProfile();
        app.getTeam().returnToHomePage1();
    }

    @Test(dataProvider = "validTeamsCSV",dataProviderClass = DataProviders.class)
    public void testModificateTeamsWithCSV (TeamData team) throws InterruptedException {

        app.getTeam().clickChoiceTeam();
        app.getTeam().clickSettings();
        app.getTeam().clickEditTeamProfile();
       // app.getTeam().clickChooceTeamTypeDropDown();
        app.getTeam().editNameAndDescriptionTeam(team);
        app.getTeam().clickSaveEditTeamProfile();
        app.getTeam().returnToHomePage1();
    }
    @Test
    public void testModificateTeams () throws InterruptedException {

        app.getTeam().clickChoiceTeam();
        app.getTeam().clickSettings();
        app.getTeam().clickEditTeamProfile();
        //app.getTeam().clickChooceTeamTypeDropDown();
        app.getTeam().editNameAndDescriptionTeam(new TeamData().setName("name").setDescription("description"));
        app.getTeam().clickSaveEditTeamProfile();
        app.getTeam().returnToHomePage1();
    }


}
