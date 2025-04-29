package com.example.enums;

import java.util.Arrays;

public enum SleepQuality {

    POOR("Poor", "Kötü"),
    FAIR("Fair", "Orta"),
    GOOD("Good", "İyi"),
    EXCELLENT("Excellent", "Mükemmel");

    private final String value;
    private final String label;

    SleepQuality(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static SleepQuality fromAny(String input) {
        return Arrays.stream(values())
                .filter(s -> s.label.equalsIgnoreCase(input) || s.value.equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Geçersiz uyku kalitesi: " + input));
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }


}
