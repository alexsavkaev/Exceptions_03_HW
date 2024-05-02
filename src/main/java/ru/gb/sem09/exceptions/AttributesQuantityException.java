package ru.gb.sem09.exceptions;

public class AttributesQuantityException extends PersonException{

    private final int attributesQuantity;

    public AttributesQuantityException(String message, int attributesQuantity) {
        super(message);
        this.attributesQuantity = attributesQuantity;
    }

    @Override
    public String getContext() {
        return String.format("%d", attributesQuantity);
    }
}