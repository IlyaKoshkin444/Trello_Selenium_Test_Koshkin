package com.telran.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamsHelper extends HelperBase{
    public TeamsHelper(WebDriver wd) {
        super(wd);
    }

    public void inviteTeamMembers() throws InterruptedException {
        Type(By.cssSelector("[class='autocomplete-input']"), "xyz444@pochta.com");
        click(By.cssSelector("[class='autocomplete-btn primary fullWidthButton']"));
        pause(5000);
    }

    public void clickCreateTeamSubmitButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
        pause(5000);
    }

    public void inputCreateTeamDescription() throws InterruptedException {
      Type(By.cssSelector("[id$=description]"), "Example for QA-22-Team");
        pause(5000);
    }

    public void inputCreateTeamTitle() throws InterruptedException {
        Type(By.cssSelector("[data-test-id='header-create-team-name-input']"), "QA-22-Team");
        pause(5000);
    }

    public void clickPlusTeamButton() throws InterruptedException {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
        pause(5000);
    }

    public int getTeamsCount() {
        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size();
    }

    public void clickConfirmDeleteTeam() throws InterruptedException {
        click(By.xpath("//input[@class='js-confirm full negate']"));
        pause(5000);
    }

    public void clickDeleteThisTeam() throws InterruptedException {
        click(By.cssSelector("[class='quiet-button']"));
        pause(5000);
    }

    public void clickSettings() throws InterruptedException {
        click(By.cssSelector("[class^=icon-gear]"));
        pause(5000);
    }

    public void clickChoiceTeam() throws InterruptedException {
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
        pause(5000);

    }

    public void deleteTeam() throws InterruptedException {
        clickChoiceTeam();
        clickSettings();
        clickDeleteThisTeam();
        clickConfirmDeleteTeam();
    }

    public void clickSaveEditTeamProfile() throws InterruptedException {
        click(By.xpath("//input[@class='primary wide js-submit-profile']"));
        pause(5000);
    }

    public void editNameAndDescriptionTeam() {
        Type(By.xpath("//input[@name='displayName']"), "QA-22 TEAM PROFESSIONAL");
        Type(By.xpath("//textarea[@name='desc']"), "Example for QA-22 TEAM PROFESSIONAL");
    }

    public void clickEditTeamProfile() throws InterruptedException {
        click(By.xpath("//a[@class='button-link tabbed-pane-header-details-edit js-edit-profile']"));
        pause(5000);
    }
    public void returnToHomePage1() throws InterruptedException {
        click(By.name("house"));
        pause(5000);
        click(By.cssSelector("[data-test-id='home-link']"));
        pause(5000);
    }
}
