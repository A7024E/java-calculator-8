package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final String CUSTOM_PATTERN = "^//(.*)\\\\n(.*)";
    private static final String DEFAULT_PATTERN = "[,:]";
    private static final String NUMBER_PATTERN = "\\d+";

    public static String[] splitByDelimiter(String input) {
        Matcher matcher = compliMatcher(input);
        if (isFindMatcher(matcher)) {
            String delimiter = findCustomDelimiter(matcher);
            return splitByCustomDelimiter(matcher, delimiter);
        }
        return splitByDefaultDelimiter(input);
    }

    private static boolean isNumeric(String input) {
        return input.matches(NUMBER_PATTERN);
    }

    private static String[] splitByDefaultDelimiter(String input) {

        if (isNumeric(input)) {
            return new String[]{input};
        }
        return input.split(DEFAULT_PATTERN);
    }

    private static String[] splitByCustomDelimiter(Matcher matcher, String delimiter) {
        return findDelimitedValues(matcher).split(delimiter);
    }

    private static Matcher compliMatcher(String input) {
        return compliePattern().matcher(input);
    }

    private static Pattern compliePattern() {
        return Pattern.compile(CUSTOM_PATTERN);
    }

    private static String findDelimitedValues(Matcher matcher) {
        return matcher.group(2);
    }

    private static String findCustomDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    private static boolean isFindMatcher(Matcher matcher) {
        return matcher.find();
    }
}


