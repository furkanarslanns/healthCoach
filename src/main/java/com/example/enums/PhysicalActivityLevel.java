package com.example.enums;

import java.util.Arrays;

public enum PhysicalActivityLevel {
    SEDENTARY("Sedentary", "Sedanter"),
    LIGHTLY_ACTIVE("Lightly Active", "Hafif aktif"),
    MODERATELY_ACTIVE("Moderately Active", "Orta aktif"),
    VERY_ACTIVE("Very Active", "Çok aktif"),
    SUPER_ACTIVE("Super Active", "Süper aktif");

    private final String value;
    private final String label;

    PhysicalActivityLevel(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static PhysicalActivityLevel fromAny(String input) {
        return Arrays.stream(values())
                .filter(p -> p.label.equalsIgnoreCase(input) || p.value.equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Geçersiz aktivite seviyesi: " + input));
    }

    public String getLabel() { return label; }
    public String getValue() { return value; }
}
