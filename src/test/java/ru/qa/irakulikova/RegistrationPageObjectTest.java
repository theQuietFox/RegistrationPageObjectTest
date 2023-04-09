package ru.qa.irakulikova;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationPageObjectTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    String name = "Jennie";
    String lastName = "Kim";
    String email = "Jennie@Kim.com";
    String number = "7894561230";
    String address = "Kannam street building 1";
    String subjects = "Arts";
    String gender = "Female";
    String hobbies = "Music";
    String picturesAddress = "src/test/resources/pictures/test.jpg";
    String picturesName = "test.jpg";
    String state = "NCR";
    String city = "Noida";


    @Test
    void successfulRegistrationForm() {

        registrationPage.openPage()
                .removeBanners()
                .setUserFirstName(name)
                .setUserLastName(lastName)
                .setUserEmail(email)
                .setUserGender(gender)
                .setUserMobileNumber(number)
                .setUserBirthDayDate("16", "January", "1996")
                .setUserSubjects(subjects)
                .setUserHobbies(hobbies)
                .uploadUserPicture(picturesAddress)
                .setUserAddress(address)
                .setUserState(state)
                .setUserCity(city)
                .clickSubmit();

        registrationPage.verifyModalAppears()
                .verifyResult("Student Name", name + " " + lastName)
                .verifyResult("Student Email", name + "@" + lastName + ".com")
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", "16 January,1996")
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picturesName)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

    }
}