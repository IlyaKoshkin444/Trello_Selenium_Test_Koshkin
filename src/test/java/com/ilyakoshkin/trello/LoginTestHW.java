package com.ilyakoshkin.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase{

    @BeforeMethod

    public void ensurePreconditions() throws InterruptedException {
        if(isAvatarPresentOnHeader()){
            logout();
        }
    }

    @Test
    public void testLoginHW() throws InterruptedException {

        fillLoginForm();
        Assert.assertTrue
                (isAvatarPresentOnHeader());

    }

    @Test
    public void testLoginHW1() throws InterruptedException {


        fillLoginForm();
        Assert.assertTrue
                (isAvatarPresentOnHeader());

    }

}

