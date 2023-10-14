package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @Test(groups = {"positive"})
    public void registrationPositiveTest() {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "coral_" + i + "@gmail.com";
        String password = "565656Ca$";
        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm("abc_" + i + "@def.com", "$Abcdef12345");
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();
        logger.info("registrationPositiveTest starts with:" + email + " & " + password);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"negative", "smoke"})
    public void registrationNegativeTestWrongEmail() {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "coral_" + i + "gmail.com";
        String password = "565656Ca$";
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativTest starts with:" + email + " & " + password);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }

    @Test(groups = {"negative", "smoke"})
    public void registrationNegativeTestWrongPassword() {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "coral_" + i + "@gmail.com";
        String password = "585656Ca";
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();
        logger.info("registrationNegativTest starts with:" + email + " & " + password);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}
