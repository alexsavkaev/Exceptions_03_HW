package ru.gb.sem09.model;


import ru.gb.sem09.exceptions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Person {
    private String name;
    private String lastname;
    private String patronymic;
    private String birthdate;
    private String phoneNumber;
    private String gender;
    private static final int numberOfAttributes = 6;

    public Person() {

    }

    public static Person fromString(String data) throws PersonException {
        Person person = new Person();
        String[] parsedData = person.parseData(data);
        person.lastname = parsedData[0];
        person.name = parsedData[1];
        person.patronymic = parsedData[2];
        person.birthdate = parsedData[3];
        person.phoneNumber = parsedData[4];
        person.gender = parsedData[5];
        return person;
    }

    private String[] parseData(String data) throws PersonException{
        String[] splitData = data.split(" ");
        checkAttributesQuantity(splitData);
        checkLastname(splitData[0].toLowerCase());
        checkName(splitData[1].toLowerCase());
        checkPatronymic(splitData[2].toLowerCase());
        checkBirthdate(splitData[3]);
        checkPhoneNumber(splitData[4]);
        checkGender(splitData[5]);
        return splitData;
    }

    private void checkAttributesQuantity(String[] attributes) throws AttributesQuantityException {
        if (attributes.length != numberOfAttributes) {
            throw new AttributesQuantityException("Введено неверное количество атрибутов", attributes.length);
        }
    }

    private void checkLastname(String name) throws NameException {

        char[] chars = name.toCharArray();
        for (char c:chars) {
            if (!Character.isLetter(c)) throw new NameException("Введена неверная фамилия", name);
        }
    }
    private void checkName(String name) throws NameException {

        char[] chars = name.toCharArray();
        for (char c:chars) {
            if (!Character.isLetter(c)) throw new NameException("Введено неверное имя", name);
        }
    }
    private void checkPatronymic(String name) throws NameException {

        char[] chars = name.toCharArray();
        for (char c:chars) {
            if (!Character.isLetter(c)) throw new NameException("Введено неверное отчество", name);
        }
    }

    private void checkBirthdate(String birthdate) throws BirthdateException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        try {
            dateFormat.parse(birthdate);
        } catch (ParseException e) {
            throw new BirthdateException("Дата введена в неверном формате", birthdate);
        }
    }
    private void checkPhoneNumber(String phoneNumber) throws PhoneNumberException {

        try {
            Long.parseLong(phoneNumber);
        }
        catch (NumberFormatException e){
            throw new PhoneNumberException("Введен некорректный номер телефона", phoneNumber);
        }
    }
    private void checkGender(String gender) throws GenderException {

        if( gender.length() != 1 || !("fm").contains(gender))
            throw new GenderException("Пол введен некорректно", gender);
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",
                getLastname(),
                getName(),
                getPatronymic(),
                getBirthdate(),
                getPhoneNumber(),
                getGender());
    }
}