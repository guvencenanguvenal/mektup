package com.gcg.mektup.core.event.lang;

public class EventInput {

    private Class<?> inputClass;
    private String inputName;
    private String inputValue;

    public Class<?> getInputClass() {
        return inputClass;
    }

    public void setInputClass(Class<?> inputClass) {
        this.inputClass = inputClass;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
}
