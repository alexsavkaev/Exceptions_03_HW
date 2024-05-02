package ru.gb.sem09;

import ru.gb.sem09.exceptions.*;
import ru.gb.sem09.model.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите данные (через пробел) в формате: Фамилия | Имя | Отчество | Дата рождения (dd.mm.yyyy) | Номер телефона | Пол (m/f)");
        String inputPersonData = getPersonData();
        Person person;
        try {
            person = Person.fromString(inputPersonData);
        } catch (PersonException e) {
            System.out.println(e.getMessage() + ": " + e.getContext());
            e.printStackTrace();
            return;
        }
        try (FileWriter fileWriter = new FileWriter(person.getLastname(), true)) {
            String output = person + "\n";
            fileWriter.write(output);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Scanner scanner = new Scanner(System.in);

    public static String getPersonData() {
        return scanner.nextLine();
    }
}