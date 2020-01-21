package com.telran.trello.test;

import com.telran.trello.model.TeamData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ModificateTeamsTest extends TestBase{

    @DataProvider
public Iterator<Object[]> validTeams() {
        List<Object[]> list =new ArrayList<>();
        list.add(new Object[]{"name DP","description DP"});
        list.add(new Object[]{"DPn",""});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validTeamsCSV() throws IOException {
        List<Object[]> list =new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/teamsPositiveCSV.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]split = line.split(",");
            list.add(new Object[]{new TeamData().setName(split[0]).setDescription(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @BeforeMethod
    public void ensurePreconditionsTestModificateTeams() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().fillLoginForm();
        }
    }

    @Test(dataProvider = "validTeams")
    public void testModificateTeamsWithDP (String name, String description) throws InterruptedException {




        app.getTeam().clickChoiceTeam();
        app.getTeam().clickSettings();
        app.getTeam().clickEditTeamProfile();
        app.getTeam().editNameAndDescriptionTeam(new TeamData().setName(name).setDescription(description));
        app.getTeam().clickSaveEditTeamProfile();
        app.getTeam().returnToHomePage1();
    }

    @Test(dataProvider = "validTeamsCSV")
    public void testModificateTeamsWithCSV (TeamData team) throws InterruptedException {




        app.getTeam().clickChoiceTeam();
        app.getTeam().clickSettings();
        app.getTeam().clickEditTeamProfile();
        app.getTeam().editNameAndDescriptionTeam(team);
        app.getTeam().clickSaveEditTeamProfile();
        app.getTeam().returnToHomePage1();
    }
    @Test
    public void testModificateTeams () throws InterruptedException {




        app.getTeam().clickChoiceTeam();
        app.getTeam().clickSettings();
        app.getTeam().clickEditTeamProfile();
        app.getTeam().editNameAndDescriptionTeam(new TeamData().setName("name").setDescription("description"));
        app.getTeam().clickSaveEditTeamProfile();
        app.getTeam().returnToHomePage1();
    }


}
