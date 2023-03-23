package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    emailInput = $("#userEmail"),
    dateOfBirthInput = $("#dateOfBirthInput"),
    genderInput = $("#genterWrapper"),
    numberInput = $("#userNumber"),
    subjectInput = $("#subjectsInput"),
    hobbyInput = $("#hobbiesWrapper"),
    userPictureUpload = $("#uploadPicture"),
    userAddressInput = $("#currentAddress"),
    stateSelect = $("#state"),
    citySelect = $("#city"),
    setUserState = $("#stateCity-wrapper"),
    setUserCity = $("#stateCity-wrapper"),
    submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyInput.$(byText(value)).click();

        return this;
    }

        public RegistrationPage setUserPicture(String value) {
        userPictureUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setUserAddress(String value) {
        userAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserState(String state) {
        stateSelect.click();
        setUserState.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setUserCity(String city) {
        citySelect.click();
        setUserCity.$(byText(city)).click();

        return this;
    }

    public void submitForm () {
        submitButton.click();

    }
}
