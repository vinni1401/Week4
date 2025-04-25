package org.example;

public class PasswordValidator {
    public boolean isValid(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}
