package ru.zzeleb;

import org.junit.jupiter.api.Test;
import pages.ModalPage;
import pages.RegistrationPage;
import static ru.zzeleb.TestData.*;

public class PracticeFormWithFakerDataTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ModalPage modalPage = new ModalPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(name)
                .setLastName(surname)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(number)
                .setBirthDate(day,month,year)
                .setSubject(subject)
                .setHobby(hobby)
                .setUserPicture(picture)
                .setUserAddress(address)
                .setUserState(state)
                .setUserCity(city)
                .submitForm();

        modalPage.verifyResultsModalAppears()
                .verifyResult("Student Name", name +" " + surname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }


}
