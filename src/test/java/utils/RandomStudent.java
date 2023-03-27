package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


public class RandomStudent {

    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        return new Faker().options().option("Male", "Female", "Other");
    }

    public static String getRandomMobile() {
        return new Faker().numerify("##########");
    }

    public static Date randomDateOfBirth = new Faker().date().birthday();

    public static String getRandomDay() {
        return new SimpleDateFormat("dd").format(randomDateOfBirth);
    }

    public static String getRandomMonth() {
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(randomDateOfBirth);
    }

    public static String getRandomYear() {
        return new SimpleDateFormat("yyyy").format(randomDateOfBirth);
    }

    public static String getRandomFile() {
        return "123.jpg";
    }

    public static String getRandomSubject() {
        return new Faker().options().option("Math", "Accounting", "Social Studies", "Arts",
                "Biology", "Physics", "Chemistry", "Computer Science", "Commerce", "Economics", "Sivics", "Hindi",
                "English", "History");
    }

    public static String getRandomHobby() {
        return new Faker().options().option("Reading", "Music", "Sports");
    }

    public static String getRandomAddress() {
        return new Faker().address().fullAddress();
    }

    static Map<String, String[]> mapStateCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

    static String state;

    public static String getRandomState() {
        state = new Faker().options().option(mapStateCity.keySet().toArray()).toString();
        return state;
    }

    public static String getRandomCity() {
        return new Faker().options().option(mapStateCity.get(state));
    }






}
