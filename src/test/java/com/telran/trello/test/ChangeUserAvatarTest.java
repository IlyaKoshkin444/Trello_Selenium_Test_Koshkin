package com.telran.trello.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeUserAvatarTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsTestChangeUserAvatar() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().fillLoginForm();
        }

    }


    @Test
    public void testChangeUserAvatar() throws InterruptedException {
        logger.info("avatar before");
        app.takeScreenshot();
        app.getSession().clickOnAvatar();
        app.getSession().openProfileAndVisibility();
        app.getSession().openAndSwitchToAtlassianProfile();
        app.getSession().addPictureAndCloseWindow(app);
        logger.info("avatar after");
        app.takeScreenshot();
    }


}

