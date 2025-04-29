package com.example.excaption;

public class BaseExcaption extends RuntimeException {
    public BaseExcaption() {}


    public BaseExcaption(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}
