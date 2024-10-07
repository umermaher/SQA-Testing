package com.umermahar.testcases.lab9;

import java.util.List;

public class EmailService {
    private LoginPage loginPage;
    private MailBox mailbox;

    private Boolean isLoggedIn = false;

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public EmailService(LoginPage loginPage, MailBox mailbox) {
        this.loginPage = loginPage;
        this.mailbox = mailbox;
    }

    public boolean login(String username, String password) {
        isLoggedIn = loginPage.login(username, password);
        return isLoggedIn;
    }

    public List<String> getEmails() {
        return mailbox.getEmails();
    }

    public void addEmail(String email) {
        mailbox.addEmail(email);
    }

    public void deleteEmail(String email) {
        mailbox.deleteEmail(email);
    }
}
