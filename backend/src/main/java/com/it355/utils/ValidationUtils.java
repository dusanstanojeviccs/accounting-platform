package com.it355.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PHONE_PATTERN =
            "([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})|" +
                    "([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})|" +
                    "([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})";


    public static boolean isValidEmail(final String hex) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(hex);

        return matcher.matches();
    }

    public static boolean isValidPhone(final String hex) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(hex);

        return matcher.matches();
    }

    public static boolean isEmpty(final String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isMaxLength(final String str, int max) {
        return str != null && str.length() > max;
    }

    public static boolean isNull(Object value) {
        return value == null;
    }
}
