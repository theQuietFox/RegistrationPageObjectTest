package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            practiceFormWrapper = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userDateOfBirth = $("#dateOfBirthInput"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesInput = $("#hobbiesWrapper"),
            userUploadPicture = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            userStateClick = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            userCityClick = $("#city"),
            submitButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormWrapper.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setUserFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserGender(String value) {
        userGenderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserMobileNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserBirthDayDate(String day, String month, String year) {
        userDateOfBirth.click();
        CalendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        userSubjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setUserHobbies(String value) {
        userHobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadUserPicture(String value) {
        File fileToUpload = new File(value);
        userUploadPicture.uploadFile(fileToUpload);

        return this;
    }

    public RegistrationPage setUserAddress(String value) {
        userAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserState(String value) {
        userStateClick.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserCity(String value) {
        userCityClick.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public RegistrationPage verifyModalAppears() {
        RegistrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

}



