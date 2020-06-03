package com.github.cln.customer.application.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class RandomNameGeneratorUtil {

    private final static List<String> FIRST_NAMES = List.of(
        "Phylis",
        "Jillian",
        "Corey",
        "Cheryll",
        "Simonne",
        "Jerilyn",
        "Willodean",
        "Jung",
        "Ingrid",
        "Idell"
    );
    private final static List<String> LAST_NAMES = List.of(
        "Smith",
        "Rogers",
        "Farrell",
        "Walker",
        "Baker",
        "Douglas",
        "Thomas",
        "Hawkins",
        "Armstrong",
        "Edwards"
    );

    private static final Random rand = new Random();
    
    private RandomNameGeneratorUtil() {
    }

    public static String generate() {
        int low = 0;
        int high = 10;
        int firstNameIndex = rand.nextInt(high-low) + low;
        int lastNameIndex = rand.nextInt(high-low) + low;
        return FIRST_NAMES.get(firstNameIndex) + " " + LAST_NAMES.get(lastNameIndex);
    }
}