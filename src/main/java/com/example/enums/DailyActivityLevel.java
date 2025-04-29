package com.example.enums;

import java.util.Arrays;

public enum DailyActivityLevel {

    POOR("Poor", "Kötü"),
    MODERATE("Moderate", "Orta"),
    GOOD("Good", "İyi");

    private final String value;
    private final String label;

    DailyActivityLevel(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static DailyActivityLevel fromAny(String input) {
        return Arrays.stream(values())
                .filter(d -> d.label.equalsIgnoreCase(input) || d.value.equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Geçersiz günlük aktivite: " + input));
    }

    public String getLabel() { return label; }
    public String getValue() { return value; }


}
