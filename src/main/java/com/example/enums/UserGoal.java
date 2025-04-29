package com.example.enums;

import java.util.Arrays;

public enum UserGoal {

    LOSE_WEIGHT("Lose Weight", "Kilo vermek"),
    GAIN_MUSCLE("Gain Muscle", "Kas yapmak");

    private final String value;
    private final String label;

    UserGoal(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static UserGoal fromAny(String input) {
        return Arrays.stream(values())
                .filter(g -> g.label.equalsIgnoreCase(input) || g.value.equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Geçersiz hedef: " + input));
    }

    public String getLabel() { return label; }
    public String getValue() { return value; }



}
