package com.umermahar.testcases.lab9;

import androidx.annotation.NonNull;

public class LoginPage {

    public boolean login(@NonNull String username, String password) {
        // Simulate a successful login for demonstration
        return username.equals("user") && password.equals("pass");
    }

}
