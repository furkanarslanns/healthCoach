package com.example.enums;

import java.util.Arrays;

public enum Gender {

        MALE("Male", "Erkek"),
        FEMALE("Female", "Kadın");

        private final String value;
        private final String label;

        Gender(String value, String label) {
            this.value = value;
            this.label = label;
        }

        public static Gender fromAny(String input) {
            return Arrays.stream(values())
                    .filter(g -> g.label.equalsIgnoreCase(input) || g.value.equalsIgnoreCase(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Geçersiz cinsiyet: " + input));
        }

        public String getLabel() { return label; }
        public String getValue() { return value; }
    }


