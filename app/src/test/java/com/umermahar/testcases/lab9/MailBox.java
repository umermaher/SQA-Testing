package com.umermahar.testcases.lab9;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<String> emails = new ArrayList<>();

    public void addEmail(String email) {
        emails.add(email);
    }

    public List<String> getEmails() {
        return emails;
    }

    public void deleteEmail(String email) {
        emails.remove(email);
    }
}
