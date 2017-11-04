package com.qalabs.pageobjects;

import com.qalabs.facebook.FacebokLoginPage;
import com.qalabs.facebook.FacebookMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POExercise1Test extends BaseTest{
    private FacebokLoginPage faceBookLogin;
    private FacebookMainPage facebookMainPage;

    @BeforeClass
    public void initializeGooglePage() {
        this.faceBookLogin = new FacebokLoginPage(this.driver);
        this.facebookMainPage = null;
    }

    @Test
    public void openFacebok() {
        faceBookLogin.open();
        Assert.assertTrue(faceBookLogin.isLoaded());
    }

    @Test (description = "Login into facebook", dependsOnMethods = {"openFacebok"})
    public void loginFacebook() {
        String email = "juan.tester.123@gmail.com";
        String password = "tester123";
        this.facebookMainPage = this.faceBookLogin.login(email, password);
        Assert.assertTrue(this.facebookMainPage.isLoaded(), "Page not loaded");
    }

    @Test (description = "Login into facebook", dependsOnMethods = {"loginFacebook"})
    public void goToProfile() {
        this.facebookMainPage.clickProfile();
        Assert.assertTrue(this.facebookMainPage.isLoaded(), "Page not loaded after changing profile");
        Assert.assertTrue(this.facebookMainPage.getCurrentUrl().contains("juan.tester.1675"), "Profile not loaded");
    }

    @Test (description = "Select profile options", dependsOnMethods = {"goToProfile"})
    public void selectOptions() {
        this.facebookMainPage.clickTimeline();
        Assert.assertTrue(this.facebookMainPage.getCurrentUrl().contains("lst="), "Didn't go to timeline");
        this.facebookMainPage.clickAbout();
        Assert.assertTrue(this.facebookMainPage.getCurrentUrl().contains("about"), "Didn't go to about");
        this.facebookMainPage.clickFriends();
        Assert.assertTrue(this.facebookMainPage.getCurrentUrl().contains("friends"), "Didn't go to friends");
        this.facebookMainPage.clickPhoto();
        Assert.assertTrue(this.facebookMainPage.getCurrentUrl().contains("photos"), "Didn't go to photo");
    }

    @Test (description = "Search any friend", dependsOnMethods = {"selectOptions"})
    public void searchFriend() {
        this.facebookMainPage.searchFriend("Jose Lopez");
        Assert.assertTrue(this.facebookMainPage.isLoaded(), "Page not loaded after searching friend");
    }
}
