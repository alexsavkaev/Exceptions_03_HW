package ru.gb.sem09.exceptions;

public class NameException extends PersonException {
    private final String name;

    public NameException(String message, String name) {
        super(message);
        this.name = name;
    }

    @Override
    public String getContext() {
        return name;
    }
}