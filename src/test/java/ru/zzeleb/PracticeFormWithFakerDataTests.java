package ru.zzeleb;

import org.junit.jupiter.api.Test;
import pages.ModalPage;
import pages.RegistrationPage;


import static utils.RandomStudent.*;


public class PracticeFormWithFakerDataTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ModalPage modalPage = new ModalPage();

    @Test
    void fillFormTest() {
        String name = getRandomFirstName();
        String surname = getRandomLastName();
        String email = getRandomEmail();
        String gender = getRandomGender();
        String number = getRandomMobile();
        String day = getRandomDay();
        String month = getRandomMonth();
        String year = getRandomYear();
        String picture = getRandomFile();
        String subject = getRandomSubject();
        String hobby = getRandomHobby();
        String address = getRandomAddress();
        String state = getRandomState();
        String city = getRandomCity();

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
