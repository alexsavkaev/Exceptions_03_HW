package ru.gb.sem09.exceptions;

public abstract class PersonException extends Exception {

    public PersonException(String message) {
        super(message);
    }

    public abstract String getContext();
}