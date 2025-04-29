package com.example.enums;

import java.util.Arrays;

public enum ExerciseExperience {

    LESS_THAN_ONE_YEAR("Less than a year", "Bir yıldan az"),
    ONE_YEAR("One year", "Bir yıl"),
    MORE_THAN_ONE_YEAR("More than a year", "Bir yıldan fazla");

    private final String value;
    private final String label;

    ExerciseExperience(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static ExerciseExperience fromAny(String input) {
        return Arrays.stream(values())
                .filter(e -> e.label.equalsIgnoreCase(input) || e.value.equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Geçersiz egzersiz geçmişi: " + input));
    }

    public String getLabel() { return label; }
    public String getValue() { return value; }




}
