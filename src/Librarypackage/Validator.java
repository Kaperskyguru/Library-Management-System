/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarypackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kapersky
 */
public class Validator {

    private Pattern EmailPattern, UsernamePattern, PasswordPattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*[A-Z]).{6,20})";
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    // ((?=.*\\d)   ....  (?=.*[@#$%])
    public Validator() {
        EmailPattern = Pattern.compile(EMAIL_PATTERN);
        UsernamePattern = Pattern.compile(USERNAME_PATTERN);
        PasswordPattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean EmailValidate(String hex) {
        matcher = EmailPattern.matcher(hex);
        return matcher.matches();
    }

    public boolean UsernameValidate(String hex) {
        matcher = UsernamePattern.matcher(hex);
        return matcher.matches();
    }

    public boolean PasswordValidate(String hex) {
        matcher = PasswordPattern.matcher(hex);
        return matcher.matches();
    }

}
