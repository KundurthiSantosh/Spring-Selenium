package com.practice.spring.springselenium.googletest;

import com.practice.spring.springselenium.SpringSeleniumTestNGTest;
import com.practice.spring.springselenium.page.google.GooglePage;
import com.practice.spring.springselenium.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends SpringSeleniumTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {

        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.getSearchComponent().isAt());

        this.googlePage.getSearchComponent().search("Spring Boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());

        Assert.assertTrue(this.googlePage.getSearchResult().getResultsCount() > 2);
        this.screenShotUtil.takeScreenShot();
    }
}
