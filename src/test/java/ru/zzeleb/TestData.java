package ru.zzeleb;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TestData {
    static Faker faker = new Faker();

    static Map<String, String[]> mapStateCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

    public static String name = faker.name().firstName();
    public static String surname = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String gender = faker.options().option("Male", "Female", "Other");
    public static String number = faker.numerify("##########");
    public static Date randomDateOfBirth = new Faker().date().birthday();
    public static String day = new SimpleDateFormat("dd").format(randomDateOfBirth);
    public static String month = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(randomDateOfBirth);
    public static String year = new SimpleDateFormat("yyyy").format(randomDateOfBirth);
    public static String picture = "123.jpg";
    public static String subject = faker.options().option("Math", "Accounting", "Social Studies", "Arts",
            "Biology", "Physics", "Chemistry", "Computer Science", "Commerce", "Economics", "Sivics", "Hindi",
            "English", "History");
    public static String hobby = faker.options().option("Reading", "Music", "Sports");
    public static String address = faker.address().fullAddress();
    public static String state = faker.options().option(mapStateCity.keySet().toArray()).toString();
    public static String city = faker.options().option(mapStateCity.get(state));

}
