package ru.gb.sem09.exceptions;

public class PhoneNumberException extends PersonException{

    private final String phoneNumber;

    public PhoneNumberException(String message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getContext() {
        return phoneNumber;
    }
}