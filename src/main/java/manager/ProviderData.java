package manager;

import models.User;
import org.testng.annotations.DataProvider;
import models.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO(){ // Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                User.builder()
                .email("coral@gmail.com")
                .password("565656Ca$")
                .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("davidtel@mail.com")
                        .password("12345!678Da")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("kiril@gmail.com")
                        .password("K893456k!")
                        .build()
        });
        return list.iterator();
    }
    @DataProvider(name = "contactDTO")
    public Iterator<Object[]> contactDTO(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Iren")
                        .lastName("Shiran")
                        .phone("4534567965")
                        .email("irena@gmail.com")
                        .address("Haifa")
                        .description("Doctor")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                .name("Lora")
                .lastName("Dubnov")
                .phone("4567045456")
                .email("lora@gmail.com")
                .address("Tel Aviv")
                .description("teacher")
                .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Amnon")
                        .lastName("Kazerman")
                        .phone("4319876822")
                        .email("Amn@gmail.com")
                        .address("Naharia")
                        .description("friend")
                        .build()
        });
        return list.iterator();
    }
}
