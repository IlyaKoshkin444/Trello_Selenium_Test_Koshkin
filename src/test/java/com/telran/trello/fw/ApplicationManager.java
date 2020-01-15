package com.telran.trello.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {
    WebDriver wd;

    BoardHelper board;
    TeamsHelper team;
    SessionHelper session;

    public void init() {
        String browser =
                System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.SAFARI)) {
            wd = new SafariDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        openSite("https://trello.com/ ");
        session =new SessionHelper(wd);
        board = new BoardHelper(wd);
        team = new TeamsHelper(wd);
    }

    public void stop() {
        wd.quit();
    }


    public void openSite(String url) {
        wd.get(url);
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamsHelper getTeam() {
        return team;
    }

    public SessionHelper getSession() {
        return session;
    }
}