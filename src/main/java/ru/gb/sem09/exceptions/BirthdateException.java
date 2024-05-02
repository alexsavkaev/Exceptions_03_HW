package ru.gb.sem09.exceptions;

public class BirthdateException extends PersonException{

    private final String birthdate;

    public BirthdateException(String message, String birthdate) {
        super(message);
        this.birthdate = birthdate;
    }

    @Override
    public String getContext() {
        return birthdate;
    }
}