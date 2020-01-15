package com.telran.trello.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase{

    @BeforeMethod

    public void ensurePreconditions() throws InterruptedException {
        if(app.getSession().isAvatarPresentOnHeader()){
            app.getSession().logout();
        }
    }

    @Test
    public void testLoginHW() throws InterruptedException {

        app.getSession().fillLoginForm();
        Assert.assertTrue
                (app.getSession().isAvatarPresentOnHeader());

    }

    @Test
    public void testLoginHW1() throws InterruptedException {


        app.getSession().fillLoginForm();
        Assert.assertTrue
                (app.getSession().isAvatarPresentOnHeader());

    }

}

