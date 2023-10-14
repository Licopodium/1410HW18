package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd){
        super(wd);
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public void logout(){
        click(By.xpath("//*[.='Sign Out']"));
    }

    public void submitLogin(){
        wd.findElement(By.xpath("//button[1]")).click();
    }
    public void submitRegistration(){
        wd.findElement(By.xpath("//button[2]")).click();
    }
    public void fillLoginRegistrationForm(String email, String password){

        type(By.xpath("//input[1]"), email);

        type(By.xpath("//input[2]"), password);
    }

    public void fillLoginRegistrationForm(User user){
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void openLoginRegistrationForm(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }

    public void login(User user){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }
}
