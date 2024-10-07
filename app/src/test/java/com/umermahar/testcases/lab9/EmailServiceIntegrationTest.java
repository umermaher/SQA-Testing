package com.umermahar.testcases.lab9;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class EmailServiceIntegrationTest {

    private EmailService emailService;

    @Before
    public void setUp() {
        emailService = new EmailService(new LoginPage(), new MailBox());
    }

    @Test
    public void loginAndExcessEmails() {
        assertTrue("Login should be successful", emailService.login("user", "pass"));

        emailService.addEmail("test@example.com");
        List<String> emails = emailService.getEmails();

        assertEquals("Should always 1",1, emails.size());
        assertEquals("Email in mailbox should match", emails.get(0), "test@example.com");
    }

    @Test
    public void testDeleteEmails() {
        emailService.login("user", "pass");
        String testEmail = "test@example.com";
        emailService.addEmail(testEmail);

        emailService.deleteEmail(testEmail);

        assertTrue(emailService.getEmails().isEmpty());
    }


}
