package tests;

import manager.ProviderData;
import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{


    @BeforeMethod(alwaysRun = true)

    public void precondition(){
        if(!app.getHelperUser().isLogged()) app.getHelperUser().login(
                User.builder()
                        .email("coral@gmail.com")
                        .password("565656Ca$")
                        .build()

        );
    }

@Test(invocationCount = 2, groups = {"positive","smoke"})
    public void addNewContactPositive(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    Contact contact = Contact.builder()
            .name("Iren")
            .lastName("Shiran")
            .phone("453456792"+i)
            .email("irena_" + i + "@gmail.com")
            .address("Haifa")
            .description("Doctor")
            .build();

    app.getHelperContact().openContactForm();
    app.getHelperContact().fillContactForm(contact);
    app.getHelperContact().submitContactForm();
    Assert.assertTrue(app.getHelperContact().isContactCreated(contact));

}

    @Test(groups = {"positive","smoke"}, dataProvider = "contactDTO", dataProviderClass = ProviderData.class)
    public void addNewContactPositiveDTO(Contact contact){
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));

    }


    @Test(groups = {"negative"})
    public void addNewContactNegative() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contact contact = Contact.builder()
                .name("Iren").
                lastName("Shiran")
                .phone("1234")
               .email("irena_" + i + "@gmail.com")
                .address("Haifa")
                .description("Doctor")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        logger.info("addNewContactNegative starts with --->" + contact.getName() + " " + contact.getLastName() + " " + contact.getPhone() + " " + contact.getEmail() + " " + contact.getAddress() + " " + contact.getDescription());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void addNewContactNegativeNameLess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 360;
        Contact contact = Contact.builder()
                .name("")
                .lastName("Shiran")
                .phone("4534567929")
                .email("irena_" + i + "@gmail.com")
                .address("Haifa")
                .description("Doctor")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        logger.info("addNewContactNegativeNameless starts with --->" + contact.getName() + " " + contact.getLastName() + " " + contact.getPhone() + " " + contact.getEmail() + " " + contact.getAddress() + " " + contact.getDescription());

}

}
