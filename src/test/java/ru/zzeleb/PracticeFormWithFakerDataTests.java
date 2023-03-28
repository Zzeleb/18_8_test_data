package ru.zzeleb;

import org.junit.jupiter.api.Test;
import pages.ModalPage;
import pages.RegistrationPage;
import utils.RandomStudent;


public class PracticeFormWithFakerDataTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ModalPage modalPage = new ModalPage();
    RandomStudent randomStudent = new RandomStudent();

    @Test
    void fillFormTest() {
        String name = RandomStudent.getRandomFirstName();
        String surname = RandomStudent.getRandomLastName();
        String email = RandomStudent.getRandomEmail();
        String gender = RandomStudent.getRandomGender();
        String number = RandomStudent.getRandomMobile();
        String day = RandomStudent.getRandomDay();
        String month = RandomStudent.getRandomMonth();
        String year = RandomStudent.getRandomYear();
        String picture = RandomStudent.getRandomFile();
        String subject = RandomStudent.getRandomSubject();
        String hobby = RandomStudent.getRandomHobby();
        String address = RandomStudent.getRandomAddress();
        String state = RandomStudent.getRandomState();
        String city = RandomStudent.getRandomCity();

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
